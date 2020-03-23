
//Name: 
import java.util.*;
/**
 * Class that finds and returns a random int value between the parameters 
 */
public class RNDM
{
    //RNDM.i(9, 10)
    /**
     * Finds and returns a random int value between the parameters 
     * @param low the lower bound of random int values
     * @param high the upper bound of random int values
     * @return the random int value
     */
    public static int i (int low, int high)
    {
        Random randomGen = new Random(); 
        int randNum = randomGen.nextInt((high - low) + 1) + low; 
        return randNum; 
    }	
}
