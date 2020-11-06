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
public class inputChar {
    
    private char    symbol;
    private int       column;

    public inputChar(char symbol, int column) {
        this.symbol = symbol;
        this.column = column;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getColumn() {
        return column;
    }
    
    
    
    
}
