package proj4;

/**
 * Testing module for the converter class. 
 * The converter has to return strings first.
 */


import org.junit.After;
import org.junit.Before;
import org.junit.Test; 


public class ConverterTest {
    

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
    public void testEquation1_convert()
    {
        //  Converter convert = new Converter("C:\\Users\\jk323\\DataStructuresProjects\\Project 4\\proj4\\equation1test.txt");
        // convert.convert();
        // assertEquals("((A+B)*(C-D)+E)/(F+G) --> AB+CD-*E+FG+/", convert.convert());
    }

    @Test
    public void testEquation2_convert()
    {
        //  Converter convert = new Converter("C:\\Users\\jk323\\DataStructuresProjects\\Project 4\\proj4\\equation1test.txt");
        // convert.convert();
        // assertEquals("((A+B)/(C-D) -->  AB+CD-/", convert.convert());
    }
    
}
