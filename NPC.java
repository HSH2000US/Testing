
//Name: 
/**
 * Inherits properties of Character
 */
public abstract class NPC extends Character 
{
    /**
     * Constructer for NPC character (cannot instantiate)
     * @param n Name of the character
     * @param h health of the character
     */
    public NPC(String n, int h)
    {
       super(n, h); 
    }
}
