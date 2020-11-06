/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author my lab
 */
public class Parser {
    
    private static final NonTerminal nonTerminals [ ]= new NonTerminal[47];
    private static final Terminal terminals [ ]= new Terminal[40];
    private static final String[][] parsingTable = new String[47][40];
    private ArrayList<Parse>  fileParses= new ArrayList<Parse> ( ); 
    private OurStack stack ;
    
    
    
    public void initializeNonTerminal()
    {
        nonTerminals[0] = new NonTerminal ("program",0);
        nonTerminals[1] = new NonTerminal ("declaration-list",1);
        nonTerminals[2] = new NonTerminal ("declaration-list'",2);
        nonTerminals[3] = new NonTerminal ("declaration",3);
        nonTerminals[4] = new NonTerminal ("declaration'",4);
        nonTerminals[5] = new NonTerminal ("type-specifier",5);
        nonTerminals[6] = new NonTerminal ("params",6);
        nonTerminals[7] = new NonTerminal ("params'",7);
        nonTerminals[8] = new NonTerminal ("param-list'",8);
        nonTerminals[9] = new NonTerminal ("param",9);
        nonTerminals[10] = new NonTerminal ("compound-stmt",10);
        nonTerminals[11] = new NonTerminal ("local-declarations",11);
        nonTerminals[12] = new NonTerminal ("local-declarations'",12);
        nonTerminals[13] = new NonTerminal ("statement-list",13);
        nonTerminals[14] = new NonTerminal ("statement-list'",14);
        nonTerminals[15] = new NonTerminal ("statement",15);
        nonTerminals[16] = new NonTerminal ("expression-stmt",16);
        nonTerminals[17] = new NonTerminal ("selection-stmt",17);
        nonTerminals[18] = new NonTerminal ("iteration-stmt",18);
        nonTerminals[19] = new NonTerminal ("loop-statement",19);
        nonTerminals[20] = new NonTerminal ("iterate-statement",20);
        nonTerminals[21] = new NonTerminal ("jump-stmt",21);
        nonTerminals[22] = new NonTerminal ("expression",22);
        nonTerminals[23] = new NonTerminal ("expression''",23);
        nonTerminals[24] = new NonTerminal ("expression'",24);
        nonTerminals[25] = new NonTerminal ("simple-expression'",25);
        nonTerminals[26] = new NonTerminal ("relop",26);
        nonTerminals[27] = new NonTerminal ("relop'",27);
        nonTerminals[28] = new NonTerminal ("additive-expression",28);
        nonTerminals[29] = new NonTerminal ("additive-expression'",29);
        nonTerminals[30] = new NonTerminal ("addop",30);
        nonTerminals[31] = new NonTerminal ("term",31);
        nonTerminals[32] = new NonTerminal ("term'",32);
        nonTerminals[33] = new NonTerminal ("mulop",33);
        nonTerminals[34] = new NonTerminal ("factor",34);
        nonTerminals[35] = new NonTerminal ("factor'",35);
        nonTerminals[36] = new NonTerminal ("args",36);
        nonTerminals[37] = new NonTerminal ("arg-list",37);
        nonTerminals[38] = new NonTerminal ("arg-list'",38);
        nonTerminals[39] = new NonTerminal ("num",39);
        nonTerminals[40] = new NonTerminal ("unsigned-num",40);
        nonTerminals[41] = new NonTerminal ("signed-num",41);
        nonTerminals[42] = new NonTerminal ("pos-num",42);
        nonTerminals[43] = new NonTerminal ("neg-num",43);
        nonTerminals[44] = new NonTerminal ("value",44);
        nonTerminals[45] = new NonTerminal ("include-command",45);
        nonTerminals[46] = new NonTerminal ("f-name",46);
    }
    
    
    public void initializeTerminal()
    {
        terminals [0]= new Terminal("ID",0);
        terminals [1]= new Terminal("$",1);
        terminals [2]= new Terminal("Low",2);
        terminals [3]= new Terminal("Slow",3);
        terminals [4]= new Terminal("Chlo",4);
        terminals [5]= new Terminal("Chain",5);
        terminals [6]= new Terminal("Lowf",6);
        terminals [7]= new Terminal("Slowf",7);
        terminals [8]= new Terminal("Worthless",8);
        terminals [9]= new Terminal("(",9);
        terminals [10]= new Terminal(")",10);
        terminals [11]= new Terminal(";",11);
        terminals [12]= new Terminal(",",12);
        terminals [13]= new Terminal("{",13);
        terminals [14]= new Terminal("}",14);
        terminals [15]= new Terminal("Law",15);
        terminals [16]= new Terminal("if",16);
        terminals [17]= new Terminal("Else",17);
        terminals [18]= new Terminal("Loopwhen",18);
        terminals [19]= new Terminal("Iteratewhen",19);
        terminals [20]= new Terminal("Turnback",20);
        terminals [21]= new Terminal("Stop",21);
        terminals [22]= new Terminal("=",22);
        terminals [23]= new Terminal("<",23);
        terminals [24]= new Terminal(">",24);
        terminals [25]= new Terminal("==",25);
        terminals [26]= new Terminal("!=",26);
        terminals [27]= new Terminal("&&",27);
        terminals [28]= new Terminal("||",28);
        terminals [29]= new Terminal("+",29);
        terminals [30]= new Terminal("-",30);
        terminals [31]= new Terminal("*",31);
        terminals [32]= new Terminal("/",32);
        terminals [33]= new Terminal("INT_NUM",33);
        terminals [34]= new Terminal("FLOAT_NUM",34);
        terminals [35]= new Terminal(".",35);
        terminals [36]= new Terminal("include",36);
        terminals[37] = new Terminal ("txt",37);
        terminals[38] = new Terminal ("<=",38);
        terminals[39] = new Terminal (">=",39);
    }

    
    public void initializeParsingTable()
    {
        parsingTable[0][2] = new String(nonTerminals[1].name);
        parsingTable[0][3] = new String(nonTerminals[1].name);
        parsingTable[0][4] = new String(nonTerminals[1].name);
        parsingTable[0][5] = new String(nonTerminals[1].name);
        parsingTable[0][6] = new String(nonTerminals[1].name);
        parsingTable[0][7] = new String(nonTerminals[1].name);
        parsingTable[0][8] = new String(nonTerminals[1].name);
        parsingTable[0][36] = new String(nonTerminals[45].name);
        parsingTable[1][2] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][3] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][4] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][5] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][6] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][7] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[1][8] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][1] = new String("EPSILON");
        parsingTable[2][2] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][3] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][4] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][5] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][6] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][7] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[2][8] = new String(nonTerminals[3].name+" "+nonTerminals[2].name);
        parsingTable[3][2] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][3] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][4] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][5] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][6] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][7] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[3][8] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+nonTerminals[4].name);
        parsingTable[4][9] = new String(terminals [9].name+" "+ nonTerminals[6].name+" "+terminals [10].name+" "+nonTerminals[10].name);
        parsingTable[4][11] = new String(terminals [11].name);
        parsingTable[5][2] = new String(terminals [2].name);
        parsingTable[5][3] = new String(terminals [3].name);
        parsingTable[5][4] = new String(terminals [4].name);
        parsingTable[5][5] = new String(terminals [5].name);
        parsingTable[5][6] = new String(terminals [6].name);
        parsingTable[5][7] = new String(terminals [7].name);
        parsingTable[5][8] = new String(terminals [8].name);
        parsingTable[6][2] = new String(terminals [2].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][3] = new String(terminals [3].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][4] = new String(terminals [4].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][5] = new String(terminals [5].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][6] = new String(terminals [6].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][7] = new String(terminals [7].name+" "+terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[6][8] = new String(terminals [8].name+" "+nonTerminals[7].name);
        parsingTable[6][10] = new String("EPSILON");
        parsingTable[7][0] = new String(terminals [0].name+" "+nonTerminals[8].name);
        parsingTable[7][10] = new String("EPSILON");
        parsingTable[8][10] = new String("EPSILON");
        parsingTable[8][12] = new String(terminals [12].name+" "+nonTerminals[9].name+" "+nonTerminals[8].name);
        parsingTable[9][2] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][3] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][4] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][5] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][6] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][7] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[9][8] = new String(nonTerminals[5].name+" "+terminals [0].name);
        parsingTable[10][13] = new String(terminals [13].name+" "+nonTerminals[11].name+" "+nonTerminals[13].name+" "+terminals [14].name);
        parsingTable[11][0] = new String(nonTerminals[12].name);
        parsingTable[11][2] = new String(nonTerminals[12].name);
        parsingTable[11][3] = new String(nonTerminals[12].name);
        parsingTable[11][4] = new String(nonTerminals[12].name);
        parsingTable[11][5] = new String(nonTerminals[12].name);
        parsingTable[11][6] = new String(nonTerminals[12].name);
        parsingTable[11][7] = new String(nonTerminals[12].name);
        parsingTable[11][8] = new String(nonTerminals[12].name);
        parsingTable[11][14] = new String(nonTerminals[12].name);
        parsingTable[11][15] = new String(nonTerminals[12].name);
        parsingTable[11][16] = new String(nonTerminals[12].name);
        parsingTable[11][18] = new String(nonTerminals[12].name);
        parsingTable[11][19] = new String(nonTerminals[12].name);
        parsingTable[11][20] = new String(nonTerminals[12].name);
        parsingTable[11][21] = new String(nonTerminals[12].name);
        parsingTable[11][29] = new String(nonTerminals[12].name);
        parsingTable[11][30] = new String(nonTerminals[12].name);
        parsingTable[11][33] = new String(nonTerminals[12].name);
        parsingTable[11][34] = new String(nonTerminals[12].name);
        parsingTable[12][0] = new String("EPSILON");
        parsingTable[12][2] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][3] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][4] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][5] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][6] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][7] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][8] = new String(nonTerminals[5].name+" "+terminals [0].name+" "+terminals [11].name+" "+nonTerminals[12].name);
        parsingTable[12][9] = new String("EPSILON");
        parsingTable[12][11] = new String("EPSILON");
        parsingTable[12][13] = new String("EPSILON");
        parsingTable[12][14] = new String("EPSILON");
        parsingTable[12][15] = new String("EPSILON");
        parsingTable[12][16] = new String("EPSILON");
        parsingTable[12][18] = new String("EPSILON");
        parsingTable[12][19] = new String("EPSILON");
        parsingTable[12][20] = new String("EPSILON");
        parsingTable[12][21] = new String("EPSILON");
        parsingTable[12][29] = new String("EPSILON");
        parsingTable[12][30] = new String("EPSILON");
        parsingTable[12][33] = new String("EPSILON");
        parsingTable[12][34] = new String("EPSILON");
        parsingTable[13][0] = new String(nonTerminals[14].name);
        parsingTable[13][9] = new String(nonTerminals[14].name);
        parsingTable[13][11] = new String(nonTerminals[14].name);
        parsingTable[13][13] = new String(nonTerminals[14].name);
        parsingTable[13][14] = new String(nonTerminals[14].name);
        parsingTable[13][15] = new String(nonTerminals[14].name);
        parsingTable[13][16] = new String(nonTerminals[14].name);
        parsingTable[13][18] = new String(nonTerminals[14].name);
        parsingTable[13][19] = new String(nonTerminals[14].name);
        parsingTable[13][20] = new String(nonTerminals[14].name);
        parsingTable[13][21] = new String(nonTerminals[14].name);
        parsingTable[13][29] = new String(nonTerminals[14].name);
        parsingTable[13][30] = new String(nonTerminals[14].name);
        parsingTable[13][33] = new String(nonTerminals[14].name);
        parsingTable[13][34] = new String(nonTerminals[14].name);
        parsingTable[14][0] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][9] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][11] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][13] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][14] = new String("EPSILON");
        parsingTable[14][15] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][16] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][18] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][19] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][20] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][21] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][29] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][30] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][33] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[14][34] = new String(nonTerminals[15].name+" "+nonTerminals[14].name);
        parsingTable[15][0] = new String(nonTerminals[16].name);
        parsingTable[15][9] = new String(nonTerminals[16].name);
        parsingTable[15][11] = new String(nonTerminals[16].name);
        parsingTable[15][13] = new String(nonTerminals[10].name);
        parsingTable[15][15] = new String(nonTerminals[17].name);
        parsingTable[15][16] = new String(nonTerminals[17].name);
        parsingTable[15][18] = new String(nonTerminals[18].name);
        parsingTable[15][19] = new String(nonTerminals[18].name);
        parsingTable[15][20] = new String(nonTerminals[21].name);
        parsingTable[15][21] = new String(nonTerminals[21].name);
        parsingTable[15][29] = new String(nonTerminals[16].name);
        parsingTable[15][30] = new String(nonTerminals[16].name);
        parsingTable[15][33] = new String(nonTerminals[16].name);
        parsingTable[15][34] = new String(nonTerminals[16].name);
        parsingTable[16][0] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[16][9] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[16][11] = new String(terminals [11].name);
        parsingTable[16][29] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[16][30] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[16][33] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[16][34] = new String(nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[17][15] = new String(terminals [15].name+" "+terminals [9].name+" "+nonTerminals[22].name+" "+terminals [10].name+" "+nonTerminals[15].name+" "+terminals [17].name+" "+nonTerminals[15].name);
        parsingTable[17][16] = new String(terminals [16].name+" "+terminals [9].name+" "+nonTerminals[22].name+" "+terminals [10].name+" "+nonTerminals[15].name);
        parsingTable[18][18] = new String(nonTerminals[19].name);
        parsingTable[18][19] = new String(nonTerminals[20].name);
        parsingTable[19][18] = new String(terminals [18].name+" "+terminals [9].name+" "+nonTerminals[22].name+" "+terminals [10].name+" "+nonTerminals[15].name);
        parsingTable[20][19] = new String(terminals [19].name+" "+terminals [9].name+" "+nonTerminals[22].name+" "+terminals [11].name+" "+nonTerminals[22].name+" "+terminals [11].name+" "+nonTerminals[22].name+" "+terminals [10].name+" "+nonTerminals[15].name);
        parsingTable[21][20] = new String(terminals [20].name+" "+nonTerminals[22].name+" "+terminals [11].name);
        parsingTable[21][21] = new String(terminals [21].name+" "+terminals [11].name);
        parsingTable[22][0] = new String(terminals [0].name+" "+nonTerminals[23].name);
        parsingTable[22][9] = new String(terminals [9].name+" "+nonTerminals[22].name+" "+terminals [10].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[22][29] = new String(nonTerminals[39].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[22][30] = new String(nonTerminals[39].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[22][33] = new String(nonTerminals[39].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[22][34] = new String(nonTerminals[39].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][9] = new String(terminals [9].name+" "+nonTerminals[36].name+" "+terminals [10].name+" "+nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][11] = new String(nonTerminals[24].name);
        parsingTable[23][22] = new String(nonTerminals[24].name);
        parsingTable[23][23] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][24] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][25] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][26] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][27] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][28] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][29] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][30] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][31] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][32] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][38] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[23][39] = new String(nonTerminals[32].name+" "+nonTerminals[29].name+" "+nonTerminals[25].name);
        parsingTable[24][10] = new String("EPSILON");
        parsingTable[24][11] = new String("EPSILON");
        parsingTable[24][12] = new String("EPSILON");
        parsingTable[24][22] = new String(terminals [22].name+" "+nonTerminals[22].name);
        parsingTable[25][10] = new String("EPSILON");
        parsingTable[25][11] = new String("EPSILON");
        parsingTable[25][12] = new String("EPSILON");
        parsingTable[25][23] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][24] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][25] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][26] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][27] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][28] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][38] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[25][39] = new String(nonTerminals[26].name+" "+nonTerminals[28].name);
        parsingTable[26][23] = new String(terminals [23].name+" "+nonTerminals[27].name);
        parsingTable[26][24] = new String(terminals [24].name+" "+nonTerminals[27].name);
        parsingTable[26][25] = new String(terminals [25].name);
        parsingTable[26][26] = new String(terminals [26].name);
        parsingTable[26][27] = new String(terminals [27].name);
        parsingTable[26][28] = new String(terminals [28].name);
        parsingTable[26][38] = new String(terminals [38].name);
        parsingTable[26][39] = new String(terminals [39].name);
        parsingTable[27][0] = new String("EPSILON");
        parsingTable[27][9] = new String("EPSILON");
        parsingTable[27][22] = new String(terminals [22].name);
        parsingTable[27][29] = new String("EPSILON");
        parsingTable[27][30] = new String("EPSILON");
        parsingTable[27][33] = new String("EPSILON");
        parsingTable[27][34] = new String("EPSILON");
        parsingTable[28][0] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[28][9] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[28][29] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[28][30] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[28][33] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[28][34] = new String(nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[29][10] = new String("EPSILON");
        parsingTable[29][11] = new String("EPSILON");
        parsingTable[29][12] = new String("EPSILON");
        parsingTable[29][23] = new String("EPSILON");
        parsingTable[29][24] = new String("EPSILON");
        parsingTable[29][25] = new String("EPSILON");
        parsingTable[29][26] = new String("EPSILON");
        parsingTable[29][27] = new String("EPSILON");
        parsingTable[29][28] = new String("EPSILON");
        parsingTable[29][38] = new String("EPSILON");
        parsingTable[29][39] = new String("EPSILON");
        parsingTable[29][29] = new String(nonTerminals[30].name+" "+nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[29][30] = new String(nonTerminals[30].name+" "+nonTerminals[31].name+" "+nonTerminals[29].name);
        parsingTable[30][29] = new String(terminals [29].name);
        parsingTable[30][30] = new String(terminals [30].name);
        parsingTable[31][0] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[31][9] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[31][29] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[31][30] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[31][33] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[31][34] = new String(nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[32][10] = new String("EPSILON");
        parsingTable[32][11] = new String("EPSILON");
        parsingTable[32][12] = new String("EPSILON");
        parsingTable[32][23] = new String("EPSILON");
        parsingTable[32][24] = new String("EPSILON");
        parsingTable[32][25] = new String("EPSILON");
        parsingTable[32][26] = new String("EPSILON");
        parsingTable[32][27] = new String("EPSILON");
        parsingTable[32][28] = new String("EPSILON");
        parsingTable[32][29] = new String("EPSILON");
        parsingTable[32][30] = new String("EPSILON");
        parsingTable[32][38] = new String("EPSILON");
        parsingTable[32][39] = new String("EPSILON");
        parsingTable[32][31] = new String(nonTerminals[33].name+" "+nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[32][32] = new String(nonTerminals[33].name+" "+nonTerminals[34].name+" "+nonTerminals[32].name);
        parsingTable[33][31] = new String(terminals [31].name);
        parsingTable[33][32] = new String(terminals [32].name);
        parsingTable[34][0] = new String(terminals [0].name+" "+nonTerminals[35].name);
        parsingTable[34][9] = new String(terminals [9].name+" "+nonTerminals[22].name+" "+terminals [10].name);
        parsingTable[34][29] = new String(nonTerminals[39].name);
        parsingTable[34][30] = new String(nonTerminals[39].name);
        parsingTable[34][33] = new String(nonTerminals[39].name);
        parsingTable[34][34] = new String(nonTerminals[39].name);
        parsingTable[35][9] = new String(terminals [9].name+" "+nonTerminals[36].name+" "+terminals [10].name);
        parsingTable[35][10] = new String("EPSILON");
         parsingTable[35][11] = new String("EPSILON");
         parsingTable[35][12] = new String("EPSILON");
         parsingTable[35][23] = new String("EPSILON");
         parsingTable[35][24] = new String("EPSILON");
         parsingTable[35][25] = new String("EPSILON");
         parsingTable[35][26] = new String("EPSILON");
         parsingTable[35][27] = new String("EPSILON");
         parsingTable[35][28] = new String("EPSILON");
         parsingTable[35][29] = new String("EPSILON");
         parsingTable[35][30] = new String("EPSILON");
         parsingTable[35][31] = new String("EPSILON");
         parsingTable[35][32] = new String("EPSILON");
         parsingTable[35][38] = new String("EPSILON");
         parsingTable[35][39] = new String("EPSILON");
         parsingTable[36][0] = new String(nonTerminals[37].name);
         parsingTable[36][9] = new String(nonTerminals[37].name);
          parsingTable[36][10] = new String("EPSILON");
          parsingTable[36][29] = new String(nonTerminals[37].name);
          parsingTable[36][30] = new String(nonTerminals[37].name);
          parsingTable[36][33] = new String(nonTerminals[37].name);
          parsingTable[36][34] = new String(nonTerminals[37].name);
          parsingTable[37][0] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[37][9] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[37][29] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[37][30] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[37][33] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[37][34] = new String(nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[38][10] = new String("EPSILON");
          parsingTable[38][12] = new String(terminals [12].name+" "+nonTerminals[22].name+" "+nonTerminals[38].name);
          parsingTable[39][29] = new String(nonTerminals[41].name);
          parsingTable[39][30] = new String(nonTerminals[41].name);
          parsingTable[39][33] = new String(nonTerminals[40].name);
          parsingTable[39][34] = new String(nonTerminals[40].name);
          parsingTable[40][33] = new String(nonTerminals[44].name);
          parsingTable[40][34] = new String(nonTerminals[44].name);
          parsingTable[41][29] = new String(nonTerminals[42].name);
          parsingTable[41][30] = new String(nonTerminals[43].name);
          parsingTable[42][29] = new String(terminals [29].name+" "+nonTerminals[44].name);
          parsingTable[43][30] = new String(terminals [30].name+" "+nonTerminals[44].name);
          parsingTable[44][33] = new String(terminals [33].name);
          parsingTable[44][34] = new String(terminals [34].name);
          parsingTable[45][36] = new String(terminals [36].name+" "+terminals [9].name+" "+nonTerminals[46].name+" "+terminals [35].name+" "+ terminals[37].name+" "+terminals [10].name+" "+terminals [11].name);
          parsingTable[46][0] = new String(terminals [0].name);
          
          
          
          
        
    }
    
    
    
    public StackInput[] reverseInput(String input)
    {
       char []array= input.toCharArray();
       ArrayList<String> action = new ArrayList<String> (); 
       String terminal = "";
       StackInput[] s = new StackInput [20];
       int singleFlag = 0;
       int j=0;
        for(char ch : array)
        {
            if( ch == ' ')
            {   singleFlag = 1 ;
                action.add(terminal);
                terminal = "";

            }
            else
            {
              terminal +=ch;  
            }
        }
        
        action.add(terminal);
        if (singleFlag == 0)
        {
            
            if( isNonTerminal(terminal)  != -1 )
            {
                s[0] = new StackInput(false,terminal,isNonTerminal(terminal));
                s[1] = new StackInput(false,terminal,-1);
                return s ;
            }
            else{
                
                s[0] = new StackInput(true,terminal,99);
                s[1] = new StackInput(false,terminal,-1);
                return s ;
                
            }
        }
        
        for (int i = action.size() - 1 ; i >=0  ; i-- , j++)
        {
            if( isNonTerminal(action.get(i))  != -1)
            {
                s[j] = new StackInput(false,action.get(i),isNonTerminal(action.get(i)));
                
            }
            else
            {
                 s[j] = new StackInput(true,action.get(i),99);
            }
        }
        
        s[j] = new StackInput(false,terminal,-1); 
               
        return s;
    }
    
    
   
    public int isNonTerminal (String input)
    {
        for (NonTerminal t : nonTerminals)
        {
            if (input.equals(t.name) )
            {
                return t.row;
            }
        }
        
        return -1 ;
        
    }
    
    
    
    public void initializeStack()
    {
        stack = new OurStack ();
        StackInput input2 = new StackInput(false,nonTerminals[0].name,nonTerminals[0].row);
        StackInput input1= new StackInput(true,terminals [1].name,terminals [1].column);
        stack.push(input1);
        stack.push(input2);
    }
    
    public boolean match (StackInput inStack,Token input)
    {
        if (inStack.getName().equals(input.getName()))
        {
            return true;
        }
        else if (inStack.getName().equals(input.getType()))
        {
            return true;
        }
        return false;
    }
    
    
    public int getTerminalColumn(Token token)
    {
        if (token.getName().equals("if"))
        {
            return 16 ;
        }
        
        for(Terminal i : terminals)
        {
            if(token.getName().equals(i.name))
            {
               return i.column;   
            
            }
                
            else if(token.getType().equals(i.name))
            {
                return i.column;
            }
            
        }
        return -1;
        
    }
    
    
    public ArrayList<Parse> parse (ArrayList<Token> tokens)
       {
            initializeStack();
            String rule ="";
            int column = -1;
            int matchFlag = 1;
            int popFlag = 0;
            int breakFlag = 0;
            int ruleFlag = 0;
            StackInput x = new StackInput (true,"",-1);
        
        for (Token tok : tokens)
        {
            rule = "" ;
            column = -1;
            matchFlag = 1;
            popFlag = 0;
           
            if(breakFlag == 1)
            { break ; }
            
            while(matchFlag == 1)
            {
                
            column = getTerminalColumn (tok);
            if (column != -1)
            {
               StackInput peak = stack.peek();
               if (!peak.isIsTerminal())
               {
                   rule = parsingTable[peak.getRow()][column] ;
                   if(rule == null)
                   {
                       rule = "";
                       Parse p = new Parse ("Not Matched",tok.getLineNumber(),x.getName());
                       fileParses.add(p);
                       breakFlag = 1 ;
                       break;
                   }
                   popFlag = 0 ;
                   ruleFlag = 0;
                   StackInput[] reverseRule = reverseInput(rule);
                   for (StackInput i : reverseRule)
                   {
                       if(i.getRow() != -1)
                       {
                            if(popFlag == 0)
                               {
                                   x= stack.pop();
                                   popFlag = 1;
                               }
                           
                           if(rule.equals("EPSILON") )
                           {    
                                if (ruleFlag == 0)
                                {
                                    Parse p = new Parse (rule,tok.getLineNumber(),x.getName());
                                    fileParses.add(p);
                                    ruleFlag = 1 ;
                                }
                           }else{
                                
                                stack.push(i);
                                
                                if (ruleFlag == 0)
                                {
                                    Parse p = new Parse (rule,tok.getLineNumber(),x.getName());
                                    fileParses.add(p);
                                    ruleFlag = 1 ;
                                }
                                 }
                       }
                       else {break;}
                       }
                   
               }
               else
               {
                   if ( match( peak,tok ) )
                           { 
                               StackInput s = stack.pop();
                               String term = s.getName();
                               rule = "matching";
                               Parse p = new Parse (rule,tok.getLineNumber(),term);
                               fileParses.add(p);

                                matchFlag = 0;
                           }
                   else
                   {
                        Parse p = new Parse ("NOT MATCHED",tok.getLineNumber(),tok.getName());
                        fileParses.add(p);
                        breakFlag = 1;
                        break;
                   }
               }
            }
            else
            {    
                 Parse p = new Parse ("NOT AVAILABLE INPUT",tok.getLineNumber(),tok.getName());
                 fileParses.add(p);
                 breakFlag = 1 ;
                 break;
            }
            rule = "";
            }
        }
        return fileParses;
    }
    
}
