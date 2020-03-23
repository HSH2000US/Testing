
//Name: 
/**
 *  Prints text in a scrolling format that slowly prints letters over time
 */
public class ScrollText
{
    /**
     * Prints text in a scrolling format that slowly prints letters over time
     * @ param t the speed in milliseconds the text is printed in
     * @ param s the text that's printed out
     */
    public void scrollText(long t, String s)
    {
        long time = t; 
        char[] charArray = s.toCharArray(); 
        for(char i : charArray)
        {
            System.out.print(i); 
            try
            {
                Thread.sleep(time);  
            }
            catch (Exception e)
            {
                System.out.print(""); 
            }
        }
    }
}
