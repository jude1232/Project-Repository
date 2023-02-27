package proj4;

/**
 * Handles a division symbol
 * 
 * @author (Jude Kappel) 
 * @version 2/26/2023
 */
public class Divide implements Token{
    public final int PRECEDENCE = 2;

    // instance var
    private String div;

    //Constructor
    public Divide()
    {
        this.div = "/";
    }

    //returns the precedence
    public int getPrecedence() 
    {
        return PRECEDENCE;
    }

    //returns a printable value of the string
    public String toString()
    {
        return div;
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
        Divide div = new Divide();
        String toReturn = "";
        while(!s.isEmpty() && this.getPrecedence() <= s.peek().getPrecedence() && !s.peek().toString().equals("(")) {
            toReturn += s.pop().toString();
        }
        s.push(div);   
        return toReturn; // return toreturn string 
    }

}
