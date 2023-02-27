package proj4;

/**
 * Write a description of class LeftParen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftParen implements Token {
    // Constants
    public final int PRECEDENCE = 0;
    
    // instance var
    private String leftParen;

    /**
     * Constructor
     */
    public LeftParen()
    {
        this.leftParen = "(";
    }

    /**
     * returns the precedence value of the operator.
     */
    public int getPrecedence() 
    {
        return PRECEDENCE;
    }

    /**
     * returns a printable version of the operator as a string.
     */
    public String toString()
    {
        return leftParen;
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
        LeftParen lp = new LeftParen();
        s.push(lp);
        return "";

    }
}
