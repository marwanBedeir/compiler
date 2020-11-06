/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author Doomana3
 */
public class Dectionry {
    
//    private ArrayList<NameType> keyWords = new ArrayList<NameType>(); 
    static private String[][] keyWords= new String[30][2];
    static private int counter = 0;
    
    public void addKeyword(String name,String type){
        keyWords[counter][0]=name;
        keyWords[counter][1]=type;
        counter++;
        
    }
    
    
    public void removeKeyword(String name){
        int temp=0;
        for (int i = 0; i < counter; i++) {
            if(keyWords[i][0].equals(name)){
                temp=i;
                break;
            }   
        }
        for (int j = temp; j <counter; j++) {
            keyWords[j][0]=keyWords[j+1][0];
            keyWords[j][1]=keyWords[j+1][1];
            
        }
        counter--;
    }
    
    public String Type(String name){
        for (int i = 0; i <counter; i++) {
            if(keyWords[i][0].equals(name)){
                return keyWords[i][1];
            }
        }
        return "ID";
    }
    public ArrayList<String> getAllKeywords(){
        ArrayList<String> output = new ArrayList<String>();
        for (int i = 0; i < counter; i++) {
            output.add(keyWords[i][0]);
        }
        return output;
    }
    
}
