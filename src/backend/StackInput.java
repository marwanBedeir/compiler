/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author my lab
 */
public class StackInput {
    
    private boolean isTerminal;
    private int row;
    private String  name;

   
    public StackInput() {
    }

    
    
    public StackInput(boolean isTerminal, String name,int row) {
        this.isTerminal = isTerminal;
        this.name = name;
        this.row = row ;
    }

    public boolean isIsTerminal() {
        return isTerminal;
    }

    public void setIsTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
    
    
    
}
