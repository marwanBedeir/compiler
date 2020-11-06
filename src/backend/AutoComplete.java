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
public class AutoComplete {
    private String input = "";
    private ArrayList<String> output = new ArrayList<String>();
    private static ArrayList<String> dec = new ArrayList<String>();
    public AutoComplete(String input){
        this.input = input;
        initializeAutoComplete();
        doAuto();
    }
    
    private void doAuto(){
        output = dec;
        char[] str = input.toCharArray();
        int i = 0;
        if(input.length() == 0){
            output.clear();
        }
        for(char ch : str){
            for(int ii = 0;ii < dec.size();ii++){
                if(ch != dec.get(ii).charAt(i)){
                    output.remove(dec.get(ii));
                }
            }
            i++;
        }
    }
    
    public void initializeAutoComplete(){
        Dectionry deckeywords = new Dectionry();
        dec = deckeywords.getAllKeywords();
    }
    public static void addWord(String word){
        dec.add(word);
    }
    public static void deleteWord(String word){
        dec.remove(word);
    }
    public ArrayList<String> getSuggestedWords(){
        return output;
    }
}
