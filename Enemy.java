
//Name: 

public class Enemy extends BattleCharacter
/**
 * Creates an enemy object
 */
{ 
    /**
     * Constructor for Enemy 
     * @param n name of the enemy
     * @param h health of the enemy
     * @param a attack power of the enemy
     * @param d defense power of the enemy
     */
    public Enemy(String n, int h, int a, int d)
    {
        super(n, h, a, d);
    }

    /**
     * Alters the stats of an instantiated enemy object
     * @param n name of the enemy
     * @param h health of the enemy
     * @param a attack power of the enemy
     * @param d defense power of the enemy
     */
    public void changeStats(Enemy obj, String n, int h, int a, int d)
    {
        obj.setName(n); 
        obj.setHealth(h); 
        obj.setAttack(a); 
        obj.setDefense(d); 
    }
    
    /**
     * Prints the introduction words of the various enemy types of the game before a fight
     * @param type enemy type 
     */
    public void introWords(String type)
    {
        if (type == "Goon")
            System.out.println(getName() + ": \"Maybe if I kill you I can learn how to rap like everyone else in this city!\""); 
        if (type == "Thug")
            System.out.println(getName() + ": \"Heheh, I'm getting the hang of this, I'mma shank you and steal yo' whip\""); 
        if (type == "Biker")
            System.out.println(getName() + ": \"Proficient I be in the school of rap, I'mma beat you as I play some trap\""); 
        if (type == "Gang Leader")
            System.out.println(getName() + ": \"Ayo yo yo, I'mma pop one in yo' tummy, can't say no\""); 
        if (type == "Gang Rapper")
            System.out.println(getName() + ": \"We out here ballin', we don' do much talkin'\""); 
    }
    
    /**
     * Prints the final words of a defeated enemy
     */
    public void lastWords()
    {
        System.out.println(getName() + ": Fo'sure, fo' sure, I'm dead yo..."); 
    }
    
    /**
     * Prints the stats of an enemy
     */
    public String toString()
    {
        return "Stats: [Name: " + getName() + "] {Health: " + getHealth() + "} {Attack: " + getAttack() + "} {Defense: " + getDefense() + "}"; 
    }
}
