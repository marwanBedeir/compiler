/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author MMB
 */

public class FileManager {
    
    private String input = "" ;
    private char[] output ;
    
    public char[] readFile(String nameOfFile){
        Scanner file;
        try {
            file = new Scanner(new File(nameOfFile));
            if(file.hasNextLine()){
                input = file.nextLine();
            }
            while(file.hasNextLine()){
                this.input += "\n"+file.nextLine();
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not founded");
        }
        input += " ";
        this.output = input.toCharArray();
        return output;
    }
    public char[] readFile(File File){
       Scanner file;
        try {
            file = new Scanner(File);
            if(file.hasNextLine()){
                input = file.nextLine();
            }
            while(file.hasNextLine()){
                this.input += "\n"+file.nextLine();
            }
            file.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not founded");
        }
        input += " ";
        this.output = input.toCharArray();
        return output;
    }
    
    public boolean creatFile(String input, String path){
        try {
            FileWriter fw = new FileWriter(new File(path));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(input);
            bw.close();
            return true;
        } catch (IOException ex) {
             System.out.println("Path not founded");
             return false;
        }  
    }
    
    public boolean deleteFile(String path){
        File f = new File(path);
        boolean bool = f.delete(); 
        return bool;
    }
}
