
/**
 * Objects that can be used for various purposes in fights and bought from the Plug
 */
public class HiddenSkill
{
    private int num; 
    private String name; 
    private String itemName; 
    private boolean locked; 

    /**
     * Constructs a HiddenSkill object
     * @param num number of hiddenSkill object for an array
     * @param name name of hiddenSkill object 
     * @param locked boolean current state of hiddenSkill (locked or unlocked)
     */
    public HiddenSkill(int num, String name, String itemName, boolean locked)
    {
        this.num = num; 
        this.name = name; 
        this.itemName = itemName; 
        this.locked = locked; 
    }

    /**
     * returns number of HiddenSkill
     */
    public int getNum()
    {
        return num;
    }

    /**
     * reutrns boolean state of the HiddenSkill
     */
    public boolean getState()
    {
        return locked;
    }

    /**
     * Unlocks the HiddenSkill object by setting it to false
     */
    public void unLock()
    {
        locked = false; 
    }
    
    /**
     * returns name of the HiddenSkill item 
     */
    public String getItemName()
    {
        return itemName; 
    }
    
    /**
     * Sets the name of the item
     * @param itemName name of the item
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName; 
    }
    
    /** 
     * Sets state of object to boolean of User choice
     * @param choose locked or unlocked boolean state
     */
    public void setLocked(boolean choose)
    {
        locked = choose;
    }
    /**
     * return name of ability
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * set name of ability
     * @param name name of skill
     */
    public void setName(String name)
    {
        this.name = name; 
    }
}
