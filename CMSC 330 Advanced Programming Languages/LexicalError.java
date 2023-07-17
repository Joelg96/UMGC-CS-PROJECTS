// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023

/* Joel Goode
 * 2/6/23
 * CMSC 330 Project 1 
 */

// Class that defines a lexical error
class LexicalError extends Exception
{
    // Constructor that creates a lexical error object given the line number and error
    public LexicalError(int line, String description)    {
        super("Lexical Error on Line: " + line + " " + description);
    }
}