package proj4;

/**
 * Write a description of class Semicolon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Semicolon implements Token{

    public final int PRECEDENCE = 0;

    private String semi;

    /**
     * Constructor
     */
    public Semicolon()
    {
        this.semi = ";";
    }

    /**
     * returns the precedence value of the operator
     */
    public int getPrecedence()
    {
        return PRECEDENCE;
    }

    /**
     * returns the operator as a printable string
     */
    public String toString()
    {
        return this.semi;
    }

    /** Processes the current token.  Since every token will handle
	 *  itself in its own way, handling may involve pushing or
	 *  popping from the given stack and/or appending more tokens
	 *  to the output string.
	 * 
	 *  @param s the Stack the token uses, if necessary, when processing itself.
	 *  @return String to be appended to the output
	 */
    public String handle(Stack<Token> s) 
    {
        String toReturn = "";
        while (!s.isEmpty()) { 
            toReturn += s.pop().toString();
        }
        return toReturn;
    }

	
}
