import static java.lang.System.*;

/**
 * This class is specifically used to name an NPC & Enemy
 */

public class EnemyCreation
{   
    /**
     * default constructer of the class
     */
    private EnemyCreation() {} 

    /**
     * Randomly chooses and returns a name from the switch statement to name NPCs
     */  
    public static String enemyName()
    {
        String n = ""; 
        switch (RNDM.i(0,9))
        {
            case 0  : n="Charles"; 
            break;

            case 1  : n="Jonathan"; 
            break;

            case 2  : n="Jotaro"; 
            break;

            case 3  : n="La'Darius"; 
            break;

            case 4  : n="La'Zerius"; 
            break;

            case 5  : n="Le'Shauna"; 
            break;

            case 6  : n="Hans Christian Anderson"; 
            break;

            case 7  : n="Sosa"; 
            break;

            case 8  : n="Jamal"; 
            break;

            case 9  : n="Joseph"; 
            break;
            default : n="error";
        } 
        return n; 
    }  
    
    /**
     * Returns a randomly chosen enemy type (weakest most likely to be chosen, strongest least likely to be chosen)
     */
    public static String enemyType()
    {
        String n = ""; 
        switch (RNDM.i(1,15))
        {
            case 1 : 
            case 2 : 
            case 3 : 
            case 4 : 
            case 5 : n="Goon"; break; 
            case 6 : 
            case 7 : 
            case 8 : 
            case 9 : n="Thug"; break; 
            case 10:
            case 11:
            case 12: n="Biker"; break; 
            case 13:
            case 14: n="Gang Leader"; break; 
            case 15: n="Gang Rapper"; break; 
        } 
        return n; 
    }  
}      
