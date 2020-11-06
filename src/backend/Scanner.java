


package backend;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author my lab
 */
public class Scanner {
    
    private Dectionry DEC = new Dectionry ( ) ;
    private static final finalState [ ]tokenType = new finalState[ 35];
    private static final inputChar [ ]inputs = new inputChar [26];
    private ArrayList<Token>  fileTokens= new ArrayList<Token> ( );
    private static final int[][] transitionTable = new int[129][26];
    
    public ArrayList<Token> scan(String fileName){
        PreProcessing preprocessing = new PreProcessing(fileName);
        return doScan(preprocessing.getOutput());
    }
    public ArrayList<Token> scan(File file){
        PreProcessing preprocessing = new PreProcessing(file);
        return doScan(preprocessing.getOutput());
    }
  
    public void initializeDectionary( )
    {
        DEC.addKeyword("Law" ,"Condition");
        DEC.addKeyword("Else" ,"Condition");
        DEC.addKeyword("Low" ,"Integer");
        DEC.addKeyword("Slow" ,"SInteger");
        DEC.addKeyword("Chlo" ,"Character");
        DEC.addKeyword("Chain" ,"String");
        DEC.addKeyword("Lowf" ,"Float");
        DEC.addKeyword("Slowf" ,"SFloat");
        DEC.addKeyword("Worthless" ,"Void");
        DEC.addKeyword("Loopwhen" ,"Loop");
        DEC.addKeyword("Iteratewhen" ,"Loop");
        DEC.addKeyword("Turnback" ,"Return");
        DEC.addKeyword("Stop" ,"Break");
        DEC.addKeyword("Loli" ,"Struct");
        DEC.addKeyword("Include" ,"Inclusion");
        
    }
        

    public void initializeFinalStates( )
    {
        tokenType[0] = new finalState(6 , "Arithmetic Operation");
        tokenType[1] = new finalState(23 , "Access Operator");
        tokenType[2] = new finalState(29 , "INT_NUM");
        tokenType[3] = new finalState(36 , "FLOAT_NUM");
        tokenType[4] = new finalState(47 , "ID");
        tokenType[5] = new finalState(45 , "ID");
        tokenType[6] = new finalState(43 , "ID");
        tokenType[7] = new finalState(52 , "ID");
        tokenType[8] = new finalState(54 , "ID");
        tokenType[9] = new finalState(56 , "ID");
        tokenType[10] = new finalState(58 , "ID");
        tokenType[11] = new finalState(62 , "Assignment Operator");
        tokenType[12] = new finalState(65 , "Relational Operators");
        tokenType[13] = new finalState(70 , "Relational Operators");
        tokenType[14] = new finalState(73 , "Relational Operators");
        tokenType[15] = new finalState(79 , "Relational Operators");
        tokenType[16] = new finalState(82 , "Relational Operators");
        tokenType[17] = new finalState(89 , "Relational Operators");
        tokenType[18] = new finalState(93 , "Logic Operators");
        tokenType[19] = new finalState(97 , "Logic Operators");
        tokenType[20] = new finalState(99 , "Arithmetic Operation");
        tokenType[21] = new finalState(101 , "Arithmetic Operation");
        tokenType[22] = new finalState(103 , "Arithmetic Operation");
        tokenType[23] = new finalState(105 , "Quotation Mark");
        tokenType[24] = new finalState(107 , "Quotation Mark");
        tokenType[25] = new finalState(109 , "Semi-Colon");
        tokenType[26] = new finalState(111 , "Logic Operators");
        tokenType[27] = new finalState(113 , "Comma");
        tokenType[28] = new finalState(115 , "Braces");
        tokenType[29] = new finalState(117 , "Braces");
        tokenType[30] = new finalState(119 , "Braces");
        tokenType[31] = new finalState(121 , "Braces");
        tokenType[32] = new finalState(123 , "Dot");
        tokenType[33] = new finalState(125,"Braces");
        tokenType[34] = new finalState(127,"Braces");
        
    }
  
    
    
    
    
    
    
    
    public void initializeInputs( )
    {
        inputs [0]= new inputChar('-',0);
        inputs [1]= new inputChar('^',1);
        inputs [2]= new inputChar('_',2);
        inputs [3]= new inputChar('@',3);
        inputs [4]= new inputChar('#',4);
        inputs [5]= new inputChar('=',5);
        inputs [6]= new inputChar('>',6);
        inputs [7]= new inputChar('<',7);
        inputs [8]= new inputChar('!',8);
        inputs [9]= new inputChar('&',9);
        inputs [10]= new inputChar('|',10);
        inputs [11]= new inputChar('+',11);
        inputs [12]= new inputChar('*',12);
        inputs [13]= new inputChar('/',13);
        inputs [14]= new inputChar('\''  ,14);
        inputs [15]= new inputChar('\"',15);
        inputs [16]= new inputChar(';',16);
        inputs [17]= new inputChar('~',17);
        inputs [18]= new inputChar(',',18);
        inputs [19]= new inputChar('[',19);
        inputs [20]= new inputChar(']',20);
        inputs [21]= new inputChar('{',21);
        inputs [22]= new inputChar('}',22);
        inputs [23]= new inputChar('.',23);
        inputs [24]= new inputChar('(',24);
        inputs [25]= new inputChar(')',25);
    }
    
    
    public void initializeTransitionTable ( )
    {
        for(int x = 0; x < 129; x++){
            for(int y = 0; y < 26 ; y++){
                transitionTable[ x ][ y ] = 128; //Error state
            }
        }
        transitionTable[ 0 ] [ 0 ] = 6 ;
        transitionTable[ 0 ] [ 1 ] = 29 ;
        transitionTable[ 0 ] [ 2 ] = 43 ;
        transitionTable[ 0 ] [ 3 ] = 45 ;
        transitionTable[ 0 ] [ 4 ] = 47 ;
        transitionTable[ 0 ] [ 5 ] = 62 ;
        transitionTable[ 0 ] [ 6 ] = 70 ;
        transitionTable[ 0 ] [ 7 ] = 79 ;
        transitionTable[ 0 ] [ 8 ] = 87 ;
        transitionTable[ 0 ] [ 9 ] = 91 ;
        transitionTable[ 0 ] [ 10 ] = 95 ;
        transitionTable[ 0 ] [ 11 ] = 99 ;
        transitionTable[ 0 ] [ 12 ] = 101 ;
        transitionTable[ 0 ] [ 13 ] = 103 ;
        transitionTable[ 0 ] [ 14 ] = 105 ;
        transitionTable[ 0 ] [ 15 ] = 107 ;
        transitionTable[ 0 ] [ 16 ] = 109 ;
        transitionTable[ 0 ] [ 17 ] = 111 ;
        transitionTable[ 0 ] [ 18 ] = 113 ;
        transitionTable[ 0 ] [ 19 ] = 115 ;
        transitionTable[ 0 ] [ 20 ] = 117 ;
        transitionTable[ 0 ] [ 21 ] = 119 ;
        transitionTable[ 0 ] [ 22 ] = 121 ;
        transitionTable[ 0 ] [ 23 ] = 123 ;
        transitionTable[ 0 ] [ 24 ] = 125 ;
        transitionTable[ 0 ] [ 25 ] = 127 ;
        transitionTable[ 6 ] [ 6 ] = 23 ;
        transitionTable[ 29 ] [ 1 ] = 29 ;
        transitionTable[ 29 ] [ 23 ] = 33 ;
        transitionTable[ 33 ] [ 1 ] = 36 ;
        transitionTable[ 36 ] [ 1 ] = 36 ;
        transitionTable[ 43 ] [ 1 ] = 58 ;
        transitionTable[ 43 ] [ 2 ] = 52 ;
        transitionTable[ 43 ] [ 3 ] = 54 ;
        transitionTable[ 43 ] [ 4 ] = 56 ;
        transitionTable[ 45 ] [ 1 ] = 58 ;
        transitionTable[ 45 ] [ 2 ] = 52 ;
        transitionTable[ 45 ] [ 3 ] = 54 ;
        transitionTable[ 45 ] [ 4 ] = 56 ;
        transitionTable[ 47 ] [ 1 ] = 58 ;
        transitionTable[ 47 ] [ 2 ] = 52 ;
        transitionTable[ 47 ] [ 3 ] = 54 ;
        transitionTable[ 47 ] [ 4 ] = 56 ;
        transitionTable[ 52 ] [ 1 ] = 58 ;
        transitionTable[ 52 ] [ 2 ] = 52 ;
        transitionTable[ 52 ] [ 3 ] = 54 ;
        transitionTable[ 52 ] [ 4 ] = 56 ;
        transitionTable[ 54 ] [ 1 ] = 58 ;
        transitionTable[ 54 ] [ 2 ] = 52 ;
        transitionTable[ 54 ] [ 3 ] = 54 ;
        transitionTable[ 54 ] [ 4 ] = 56 ;
        transitionTable[ 56 ] [ 1 ] = 58 ;
        transitionTable[ 56 ] [ 2 ] = 52 ;
        transitionTable[ 56 ] [ 3 ] = 54 ;
        transitionTable[ 56 ] [ 4 ] = 56 ;
        transitionTable[ 58 ] [ 1 ] = 58 ;
        transitionTable[ 58 ] [ 2 ] = 52 ;
        transitionTable[ 58 ] [ 3 ] = 54 ;
        transitionTable[ 58 ] [ 4 ] = 56 ;
        transitionTable[ 62 ] [ 5 ] = 65 ;
        transitionTable[ 70 ] [ 5 ] = 73 ;
        transitionTable[ 79 ] [ 5 ] = 82 ;
        transitionTable[ 87 ] [ 5 ] = 89 ;
        transitionTable[ 91 ] [ 9 ] = 93 ;
        transitionTable[ 95 ] [ 10 ] = 97 ;
        
    }
    
        
    private String getDectionary(String name)
    {
        return DEC.Type(name);
    }

   
        
    private String getType(int State)
    {
        for(finalState i : tokenType)
        {
            if(State == i.getFinaleState())
            {
                return i.getType();
            }
            
        }
        return "NOT FOUND";
        
        
    }
    
    
    private int getcharColumn (char ch)
    {
        for (int i = 0 ; i < 26 ; i++) 
        {
            if(inputs [i].getSymbol() == ch)
            {
                return  inputs[i].getColumn() ;
            }
        
        }
        
        return -1;
    }
        
    
    
    
    

private ArrayList<Token> doScan (char[ ] input)
{
    
     String token = "" , type="";       
    
     int errorFlag = 0 ;     
     int state = 0 ,lineNumber = 1,newState=0 , charColumn = -1;

    for(char ch : input)
    {   
        
        if ( !((ch == ' ' || ch == '\t' ) ||  ch == '\n')  )
        {
        
        int ascii = ch ;
        
        if (ascii >= 48 && ascii <= 57)
        {   
            
            charColumn = 1 ;
        }
        else if (ascii >= 97 && ascii <= 122)
        {
            
            charColumn = 3 ;
        }
        else if (ascii >= 65 && ascii <= 90)
        {
            
            charColumn = 4 ;
        }
        else 
            {
                charColumn = getcharColumn(ch);
                                        
            }
                        
        if(charColumn != -1)
        {
        newState = transitionTable[state][charColumn] ;
        }
        else
        {
            
            errorFlag = 1 ;
            type = "ERROR" ;
        }
        if(newState == 0)
        {
             errorFlag = 1 ;
            type = "ERROR" ;
        }    
        
           if(errorFlag == 0)
           {
               state = newState ;
           }
           
           token += ch ;
           charColumn = -1;
  
        }           
           
       else if (ch == '\n' &&   ( getType(state) != "NOT FOUND" ) )
       {
           
           if(errorFlag == 0)
           {
                type = getType(state);
                if(type == "ID")
                {
                    type = getDectionary(token);
                    
                }
           }
           Token token1 = new Token (token,lineNumber,type);
           lineNumber += 1 ;
           fileTokens.add(token1);
           
           token ="";
           state = 0;
           errorFlag = 0 ;
           charColumn = -1 ;
       }
       else if (  (ch == ' ' || ch == '\t' ) &&  (getType(state) != "NOT FOUND")  )
       {  
            if(errorFlag == 0)
           {
                type = getType(state);
                if(type == "ID")
                {
                    type = getDectionary(token);
                }
           }
           Token token1 = new Token (token,lineNumber,type);
           fileTokens.add(token1);
           
            token ="";
            state = 0;
            errorFlag = 0 ;
            charColumn = -1 ;
       }
       else if(token == "" )
       {    
          lineNumber ++; 
          continue;
       }else
       {
           type = "ERROR" ;
           Token token1 = new Token (token,lineNumber,type);
           fileTokens.add(token1);
           
            token ="";
            state = 0;
            errorFlag = 0 ;
            charColumn = -1 ;
       }
        
           
       }
        if(fileTokens.size() == 7){
            if(fileTokens.get(0).getType().equals("Inclusion") && fileTokens.get(1).getName().equals("(") && fileTokens.get(3).getType().equals("Dot") && fileTokens.get(4).getType().equals("ID") && fileTokens.get(5).getName().equals(")") && fileTokens.get(6).getName().equals(";")){
                String fileName = fileTokens.get(2).getName()+"."+fileTokens.get(4).getName();
                fileTokens.clear();
                return scan(fileName);
            }else{
                return fileTokens;
            }
        }else{
            return fileTokens;
        }
    }    
    
}
