/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;

/**
 *
 * @author MMB
 */
public class PreProcessing {
    
    private char[] input;
    private char[] output;
    public PreProcessing(String fileName){
        FileManager file = new FileManager();
        this.input = file.readFile(fileName);
        if(input != null){
            doProcessing();
        }else{
            System.out.println("Error in pre processing");
        }
    }
    
    
    public PreProcessing(File file){
        FileManager fileManager = new FileManager();
        this.input = fileManager.readFile(file);
        if(input != null){
            doProcessing();
        }else{
            System.out.println("Error in pre processing");
        }
    }
    
    private void doProcessing(){
        //To remove any Comment
        String hold = "";
        int singleLineFlag = 0;
        int multiLineFlag = 0;
        int multiLineFlag2 = 0;
        int i = 0;
        
        for (char ch : input) {
            if(singleLineFlag == 0)
            {
                if(multiLineFlag == 0){
                    if(ch == '/' && input[i+1] == '/' && input[i+2] == '/'){
                        singleLineFlag = 1;
                    }
                    else if(ch == '/' && input[i+1] == '-'){
                        multiLineFlag = 1;
                    }
                    else{
                        if(multiLineFlag2 == 1)
                        {
                            multiLineFlag2 = 0;
                        }
                        else{
                            hold += ch;
                        }
                    }
                }
                else{
                    if(ch == '\n'){
                        hold += ch;
                    }
                    if(ch == '-' && input[i+1] == '/')
                    {
                        multiLineFlag = 0;
                        multiLineFlag2 = 1;
                    }
                }
            }
            else{
                if(ch == '\n'){
                    hold += ch;
                    singleLineFlag = 0;
                }
            }
            i++;    
        }
        input = hold.toCharArray();
        
        //SPLIT THEM ALL HaHaHa
        int numFlag = 0;
        int idFlag = 0;
        int ascii = 0;
        hold = "";
        i = 0;
        for (char ch : input) {
            ascii = ch;
                if(numFlag == 0){
                    if(idFlag == 0){
                        if(ascii >= 48 && ascii <= 57 ){
                            numFlag = 1;
                            hold += " ";
                            hold += ch;
                        }
                        else if((ascii >= 97 && ascii <= 122) ||(ascii >= 65 && ascii <= 90)){
                            idFlag = 1;
                            hold += " ";
                            hold +=ch;
                        }else{
                            if(i!=0){
                                if(((ch == '=')&&((input[i-1] == '=')||(input[i-1] == '!')||(input[i-1] == '<')||(input[i-1] == '>')))||((ch == '&')&&(input[i-1] == '&'))||((ch == '|')&&(input[i-1] == '|'))){
                                hold += ch;
                                }else{
                                    hold += " ";
                                    hold += ch;
                                }
                            }else{
                                hold += " ";
                                hold += ch;
                            }
                            
                        }
                    }else{
                        if((ascii >= 97 && ascii <= 122) ||(ascii >= 65 && ascii <= 90)){
                            hold += ch;
                        }else{
                            hold += " ";
                            hold += ch;
                            idFlag = 0;
                           
                        }

                    }
                }else{
                    if((ascii >= 48 && ascii <= 57) || (ascii >= 97 && ascii <= 122) ||(ascii >= 65 && ascii <= 90)){
                        hold += ch;
                    }else{
                            
                        hold += " ";
                        hold += ch;
                        numFlag = 0;
                    }
                }
            i++;
        }
        input = hold.toCharArray();
        
        //Remove extra spaces
        int spaceFlag = 0;
        i = 0;
        hold = "";
        for (char ch : input) {
            if(spaceFlag == 0){
                hold += ch;
                if(ch == ' '){
                    spaceFlag = 1;
                }
            }else{
                if(ch != ' '){
                    spaceFlag = 0;
                    hold += ch;
                }
            }
            
        }
        input = hold.toCharArray();
        // remove space
        int newLineFlag = 1;
        hold = "";
        for (char ch : input) {
            if(newLineFlag == 0){
                hold += ch;
                if(ch == '\n'){
                    newLineFlag = 1;
                }
            }else{
                if(ch != ' '){
                    hold += ch;
                    newLineFlag = 0;
                    if(ch == '\n'){
                    newLineFlag = 1;
                }
                }
            }
        }
        input = hold.toCharArray();
        if(hold.length() > 0){
            if(input[hold.length() - 1] != ' '){
                hold += ' ';
            }
        }
        input = hold.toCharArray();
        output = input;
    }
    
    public char[] getOutput(){
        return output;
    }
    
}
