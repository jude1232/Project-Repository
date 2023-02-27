package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Write a description of class Converter here.
 * 
 * @author Jude Kappel
 * @version 2/21/2023
 */
public class Converter {
	
	private Scanner myReader;

	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
		try {
            myReader = new Scanner(new File(infile)); 
    	} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	/**
	 * reads the input file and tells each character to "handle" itself
	 * creates a new token object for each character read
	 */
	public void convert() {
		String toReturn = "";
		while (myReader.hasNext()) {
			Stack<Token> s = new Stack<Token>();
			String nextExpression = myReader.next();
			for (char c : nextExpression.toCharArray()) {
				// System.out.println(c);
				if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || c == 'G'){
					toReturn += c;
					s.addToPostfix(String.valueOf(c));
				}
				else if (c == '(') {
					toReturn += c;
					LeftParen lp = new LeftParen();
					s.addToPostfix(lp.handle(s));
				}
				else if (c == ')') {
					toReturn += c;
					RightParen rp = new RightParen();
					s.addToPostfix(rp.handle(s));
				}
				else if (c == '^') {
					toReturn += c;
					Exponent exp = new Exponent();
					s.addToPostfix(exp.handle(s));
				}
				else if (c == '*') {
					toReturn += c;
					Multiply mult = new Multiply();
					s.addToPostfix(mult.handle(s));
				}
				else if (c == '/') {
					toReturn += c;
					Divide div = new Divide();
					s.addToPostfix(div.handle(s));
				}
				else if (c == '+') {
					toReturn += c;
					Plus plus = new Plus();
					s.addToPostfix(plus.handle(s));
				}
				else if (c == '-') {
					toReturn += c;
					Minus minus = new Minus();
					s.addToPostfix(minus.handle(s));
				}
				else {
					Semicolon semi = new Semicolon();
					s.addToPostfix(semi.handle(s));
				}
			}
			toReturn += " --> " + s.getPostfix();
			System.out.println(toReturn);
		}       
	}
}
