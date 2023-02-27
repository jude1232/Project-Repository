package proj4;

/**
 * Handles a multiplication symbol
 * 
 * @author Jude Kappel 
 * @version 2/26/2023
 */
public class Multiply implements Token{
    public final int PRECEDENCE = 2;

    private String mult;

    public Multiply() 
    {
        this.mult = "*";
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
        return mult;
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
        Multiply mult = new Multiply();
        String toReturn = "";
        while(!s.isEmpty() && this.getPrecedence() <= s.peek().getPrecedence() && !s.peek().toString().equals("(")) {
            toReturn += s.pop().toString();
        }
        s.push(mult);   
        return toReturn; // return toreturn string 
    }

}
