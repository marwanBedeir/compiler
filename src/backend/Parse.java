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
public class Parse {
    
        private String name;
        private String ruleUsed;
        private int     lineNumber;

    public Parse(String ruleUsed, int lineNumber,String name) {
        this.ruleUsed = ruleUsed;
        this.lineNumber = lineNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getRuleUsed() {
        return ruleUsed;
    }

    public void setRuleUsed(String ruleUsed) {
        this.ruleUsed = ruleUsed;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
     
}
