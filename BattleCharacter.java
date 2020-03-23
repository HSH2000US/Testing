
//Name: 
/**
 * Battle character inheriting properites of a Character with attack and defense
 */
public abstract class BattleCharacter extends Character 
{
    private int attack; 
    private int defense; 
    /**
     * Constructor for a BattleCharacter (cannot instantiate)
     * @param n name of the battleCharacter
     * @param h health of the BattleCharacter
     * @param a attack power of the BatteCharacter
     * @param d defense power of the battleCharacter
     */
    public BattleCharacter(String n, int h, int a, int d)
    {
        super(n, h); 
        attack = a; 
        defense = d; 
    }
    
    /**
     * sets the attack of the battleCharacter
     * @param a the name of the battlecharacter
     */
    public void setAttack(int a)
    {
        attack = a; 
    }
    
    /**
     * sets the defense of the battleCharacter
     * @param d the defense of the battlecharacter
     */
    public void setDefense(int d)
    {
        defense = d; 
    }
    
    /**
     * returns the attack power of the character
     */
    public int getAttack()
    {
        return attack; 
    }
    
    /**
     * returns the defense of the character
     */
    public int getDefense()
    {
        return defense; 
    }
}
