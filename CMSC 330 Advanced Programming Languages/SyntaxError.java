// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023

/* Joel Goode
 * 2/6/23
 * CMSC 330 Project 1 
 */

// Class that defines a syntax error
class SyntaxError extends Exception
{
    // Constructor that creates a syntax error object given the line number and error
    public SyntaxError(int line, String description) {
        super("Syntax Error on Line: " + line + " " + description);
    }
}