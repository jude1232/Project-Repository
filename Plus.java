package proj4;

/**
 * Class implementing the Token interface to handle 
 * the addition operator.
 * 
 * @author Jude Kappel
 * @version 2/20/2023
 */
public class Plus implements Token {
    public final int PRECEDENCE = 1;
    private String plus;

    /**
     * Constructor
     */
    public Plus() 
    {
        this.plus = "+";
    }
 
    /**
     * returns a printable version of the plus.
     */
    public String toString() {
    	return plus;
    }

    /**
     * returns the precedence value
     */
    public int getPrecedence() 
    {
        return PRECEDENCE;
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
        Plus plus = new Plus();
        String toReturn = "";
        while(!s.isEmpty() && this.getPrecedence() <= s.peek().getPrecedence() && !s.peek().toString().equals("(")) {
            toReturn += s.pop().toString();
        }
        s.push(plus);   
        return toReturn; // return toreturn string 
    }
}
