package proj4;

/**
 * Module containing tests for operators.
 */

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test; 

public class OperatorTest {


    public Stack<Token> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testexponent_handle()
    {
        Exponent exp = new Exponent();
        exp.handle(stack);
        assertEquals("{>^}", stack.toString());
    }

    @Test
    public void testPlus()
    {
        //(A+B);
        LeftParen lp = new LeftParen();
        lp.handle(stack);
        stack.addToPostfix("A");
        Plus plus = new Plus();
        plus.handle(stack);
        stack.addToPostfix("B");
        RightParen rp = new RightParen();
        rp.handle(stack);
        Semicolon semi = new Semicolon();
        semi.handle(stack);
        assertEquals("AB+", stack.getPostfix());
    }

    @Test
    public void testMult_exponent()
    {
        stack.addToPostfix("A");
        Divide div = new Divide();
        div.handle(stack);
        stack.addToPostfix("B");
        Exponent exp = new Exponent();
        exp.handle(stack);
        stack.addToPostfix("C");
        Minus min = new Minus();
        min.handle(stack);
        stack.addToPostfix("D");
        Semicolon semi = new Semicolon();
        semi.handle(stack);
        assertEquals("ABC^/D-", stack.getPostfix());

    }

    @Test
    public void testPlus_precedence()
    {
        stack.addToPostfix("A");
        Plus plus = new Plus();
        plus.handle(stack);
        stack.addToPostfix("B");
        // Minus min = new Minus();
        Plus p = new Plus();
        p.handle(stack);
        stack.addToPostfix("C");
        Semicolon semi = new Semicolon();
        semi.handle(stack);

        assertEquals("AB+C+", stack.getPostfix());
    }

    @Test
    public void testMinus_precedence()
    {
        stack.addToPostfix("A");
        Plus plus = new Plus();
        plus.handle(stack);
        stack.addToPostfix("B");
        Minus min = new Minus();
        // Plus p = new Plus();
        min.handle(stack);
        stack.addToPostfix("C");
        Semicolon semi = new Semicolon();
        semi.handle(stack);

        assertEquals("AB+C-", stack.getPostfix());
    }

    @Test
    public void testMult_precedence()
    {
        LeftParen lp = new LeftParen();
        lp.handle(stack);
        stack.addToPostfix("A");
        // Plus plus = new Plus();
        // plus.handle(stack);
        Multiply mult = new Multiply();
        mult.handle(stack);
        stack.addToPostfix("B");
        RightParen rp = new RightParen();
        rp.handle(stack);
        Minus min = new Minus();
        // Plus p = new Plus();
        min.handle(stack);
        stack.addToPostfix("C");
        Semicolon semi = new Semicolon();
        semi.handle(stack);

        assertEquals("AB*C-", stack.getPostfix());
    }



}
