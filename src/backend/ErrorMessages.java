/*
 * The MIT License
 *
 * Copyright 2019 MMB.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author MMB
 */
public class ErrorMessages {
    
    public String ScanMessage(ArrayList<Token> tokens){
        String message = "";
        int totalNumOfErrors = 0;
        for(Token token : tokens){
            if(token.getType().equals("ERROR")){
                totalNumOfErrors ++;
            }
            message += "\n  Line "+token.getLineNumber()+"  Token Text: "+token.getName()+"  Token Type: "+token.getType();
        }
        message += "\n\n  Total NO of errors: " + totalNumOfErrors;
        return message;
    }
    
    public String parseMessage(ArrayList<Parse> parses){
        String message = "";
        int totalNumOfErrors = 0;
             System.out.println(parses.size() );
        for(Parse parse : parses){
            if(parse.getLineNumber() == 0){
                break;
            }
            if(parse.getRuleUsed().equals("NOT MATCHED") || parse.getRuleUsed().equals("NOT AVAILABLE INPUT")){
                totalNumOfErrors ++;
                message += "\n  Line "+parse.getLineNumber() + " " + parse.getName() + " :"+" "  + parse.getRuleUsed();
            }else{
                message += "\n  Line "+parse.getLineNumber()+ " " + parse.getName() + " :"+"  Rule used: "+parse.getName() +" -> "+ parse.getRuleUsed() ;
            }
        }
        message += "\n\n Total NO of errors: " + totalNumOfErrors;
        return message;
    }
    
    public String compileMessage(ArrayList<Parse> parses, ArrayList<Token> tokens){
        String message = "";
        int totalNumOfErrors = 0;
        for(Token token : tokens){
            if(token.getType().equals("ERROR")){
                totalNumOfErrors ++;
                message += "\n  Error in Line "+token.getLineNumber();
            }
        }
        for(Parse parse : parses){
            if(parse.getRuleUsed().equals("NOT MATCHED") || parse.getRuleUsed().equals("NOT AVAILABLE INPUT")){
                totalNumOfErrors ++;
                message += "\n  Line "+parse.getLineNumber()+"  Not Matched";
            }
        }
        
        message += "\n\n  Total NO of errors: " + totalNumOfErrors;
        return message;
    }
}
