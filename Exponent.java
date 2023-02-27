package proj4;

/**
 * Write a description of class Exponent here.
 * 
 * @author Jude Kappel 
 * @version 2.23.2023
 */
public class Exponent implements Token{
    public final int PRECEDENCE = 3;    

    private String exp;

    /**
     * Constructor
     */
    public Exponent()
    {
        this.exp = "^";
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
        return exp;
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
        Exponent expon = new Exponent();
        String toReturn = "";
        while(!s.isEmpty() && this.getPrecedence() <= s.peek().getPrecedence() && !s.peek().toString().equals("(")) {
            toReturn += s.pop().toString();
        }
        s.push(expon);   
        return toReturn; // return toreturn string 
    }
}
