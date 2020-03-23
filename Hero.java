
//Name: 
/**
 * 
 */
public class Hero extends BattleCharacter
/**
 * Creates the main character
 */
{
    private int clout = 0; 
    /**
     * Constructor for Hero 
     * @param n name of the hero
     * @param h health of the hero
     * @param a attack power of the hero
     * @param c clout currently in the possession of the hero 
     */
    public Hero(String n, int h, int a, int d, int c)
    {
        super(n, h, a, d);
        clout = c; 
    }
    
    /**
     * returns the clout of the character
     */
    public int getClout()
    {
        return clout; 
    }
    
    /**
     * sets the clout of the Hero
     * @param c the amount the user wants to set clout to
     */
    public void setClout(int c)
    {
        clout = c; 
    }

    /**
     * Prints the stats of the Hero
     */
    public String toString()
    {
        return "Stats: [Name: " + getName() + "] {Health: " + getHealth() + "} {Attack: " + getAttack() + "} {Defense: " + getDefense() + "}" + " {Clout: " + clout + "}"; 
    }
}
