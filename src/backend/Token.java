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
public class Token {
    private String name;
    private int lineNumber;
    private String type;
    
  public Token (String name,int lineNumber,String type)
  {
      this.name = name;  
      this.lineNumber = lineNumber;
      this.type = type;
      
  }

    public String getName() {
        return name;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getType() {
        return type;
    }
}
