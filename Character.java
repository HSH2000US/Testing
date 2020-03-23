
//Name: 

public abstract class Character
/** 
 * Charater object class that is inherited by all other sub-classes 
 */
{
    private String name; 
    private int health; 
    /**
     * Constructs a Character
     * @param n the name of the Character
     * @param h the health of the Character
     */
    public Character(String n, int h)
    {
        name = n; 
        health = h; 
    }

    /**
     * returns the name of the Character
     */
    public String getName()
    {
        return name; 
    }

    /**
     * sets the name of the Character
     * @param n the name of the character
     */
    public void setName(String n)
    {
        name = n; 
    }

    /** 
     * returns the health of the character
     */
    public int getHealth()
    {
        return health; 
    }

    /**
    * sets the health of the Character
    * @param h the health of the character
    *
    */ 
    public void setHealth(int h)
    {
        health = h; 
    }

}
