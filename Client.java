package proj4;
/**
 * Write a description of class Client here.
 * 
 * @author Jude Kappel
 * @version (a version number or a date)
 */

public class Client
{
    public static void main(String[] args)
    {
        Converter converter = new Converter("proj4_input.txt");
        converter.convert();
    }
}
