package proj4;

/**
 * Write a description of class Minus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Minus implements Token{
    public final int PRECEDENCE = 1;

    private String minus;

    /**
     * Constructor
     */
    public Minus()
    {
        this.minus = "-";
    }

    /**
     * returns the precedence value of the operator
     */
    public int getPrecedence() 
    {
        return PRECEDENCE;
    }

    /**
     * returns a printable string representation of the operator
     */
    public String toString()
    {
        return minus;
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
        Minus min = new Minus();
        String toReturn = "";
        while(!s.isEmpty() && this.getPrecedence() <= s.peek().getPrecedence() && !s.peek().toString().equals("(")) {
            toReturn += s.pop().toString();
        }
        s.push(min);   
        return toReturn; // return toreturn string 

    }
}
