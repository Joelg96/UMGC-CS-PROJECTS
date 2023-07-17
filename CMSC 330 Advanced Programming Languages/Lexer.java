// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023

/* Joel Goode
 * 2/6/23
 * CMSC 330 Project 1
 */

import java.io.*;

// This class provides the lexical analyzer for project 1
class Lexer {

    private static final int KEYWORDS = 8;
    private StreamTokenizer tokenizer;
    private String punctuation = ",;.()";
    private Token[] punctuationTokens = {Token.COMMA, Token.SEMICOLON, Token.PERIOD, Token.LEFT_PAREN, Token.RIGHT_PAREN };

    // Constructor that creates a lexical analyzer object given the source file
    public Lexer(File file) throws FileNotFoundException {
        tokenizer = new StreamTokenizer(new FileReader(file));
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }

    // Returns the next token in the input stream
    public Token getNextToken() throws LexicalError, IOException {
        int token = tokenizer.nextToken();
        switch (token) {
            case StreamTokenizer.TT_NUMBER:
                return Token.NUMBER;
            case StreamTokenizer.TT_WORD:
                for (Token aToken : Token.values()) {
                    if (aToken.ordinal() == KEYWORDS)
                        break;
                    if (aToken.name().replace("_","").equals(tokenizer.sval.toUpperCase()))
                        return aToken;
                }
                
                // JG ADDED- Added the following code to handle the new tokens
                    if (tokenizer.sval.equals("IsoscelesTriangle"))
                        return Token.ISOSCELES_TRIANGLE;
                    if (tokenizer.sval.equals("Parallelogram"))
                        return Token.PARALLELOGRAM;
                    if (tokenizer.sval.equals("RegularPolygon"))
                        return Token.REGULAR_POLYGON;
                    if (tokenizer.sval.equals("Offset"))
                        return Token.OFFSET;
                    if (tokenizer.sval.equals("Text"))
                        return Token.TEXT;
                    if (tokenizer.sval.equals("Sides"))
                        return Token.SIDES;
                    if (tokenizer.sval.equals("Radius"))
                        return Token.RADIUS;
                    if (tokenizer.sval.equals("String"))
                        return Token.STRING;
                // ^ End of JG ADD ^
                
                return Token.IDENTIFIER;
            case StreamTokenizer.TT_EOF:
                return Token.EOF;
                
            default:
                for (int i = 0; i < punctuation.length(); i++)
                    if (token == punctuation.charAt(i))
                        return punctuationTokens[i];
        }
        return Token.EOF;
    }

    // Returns the lexeme associated with the current token

    public String getLexeme() {
        return tokenizer.sval;
    }

    // Returns the numeric value of the current token for numeric tokens

    public int getNumber() {
        return (int) tokenizer.nval;
    }

    // Returns the current line of the input file

    public int getLineNo() {
        return tokenizer.lineno();
    }
}