package proj4;

/**
 * Handles a RightParenthesis
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightParen implements Token{

    // Constants
    public final int PRECEDENCE = 0;

    //instance vars
    private String rparen;

    /**
     * Constructor
     */
    public RightParen()
    {
        this.rparen = ")";
    }

    /**
     * returns the integer value of precedence for the operator
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
        return this.rparen;
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
        String toReturn = "";
        while(!s.isEmpty() && !s.peek().toString().equals(lp.toString()) && !s.peek().toString().equals("(") ) {
            toReturn += s.pop().toString();
        }
        s.pop();
        return toReturn;
    }
}

