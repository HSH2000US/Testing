
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * Plug class; can trade with Hero
 */
public class Plug extends NPC
{
    /**
     * Constructs a Plug
     * @param n the name of the NPC
     * @param h the health of the NPC (Character requires this)
     */
    public Plug(String n, int h){
        super(n,h);
    }

    /**
     * Displays a conversation between the Plug and the Hero
     */
    public void talk(){
        ScrollText obj = new ScrollText(); 
        obj.scrollText(25L, getName() + ": \"Peep the goods I got...maybe you'll like what you see and cop!\"");
        out.println(); 
    }

    /**
     * Allows the Hero to trade clout for various hidden skills. The Hero can decline the offer as well.
     * @param hero the Hero the Plug will trade with
     */
    public void trade(Hero hero, HiddenSkill skillArray[]){
        Scanner keyboard = new Scanner(System.in);
        Scanner console = new Scanner(System.in); 
        ScrollText obj = new ScrollText(); 
        obj.scrollText(25L,"Would you like to buy from me?"); 
        out.println(); 
        out.print("(1)Yes or (2)No >>> "); 
        int choice = console.nextInt(); 
        boolean transaction = true; 
        if(choice == 2)
            transaction = false;
        while(transaction == true)
        {
            for(int i = 0; i < skillArray.length; i++)
            {
                if(skillArray[i].getState() == false)
                    skillArray[i].setItemName("Already Unlocked!"); 
            }
            obj.scrollText(25L,"What would you like to buy from me?"); 
            out.println(); 
            out.print("(1)" + skillArray[0].getItemName() + "(20 Clout)\t\t(2)" + skillArray[1].getItemName() + "(50 Clout)\n(3)" + skillArray[2].getItemName());
            out.print("(100 Clout)\t\t\t(4)" + skillArray[3].getItemName() + "(50 Clout)\n(5)" + skillArray[4].getItemName() + "(50 Clout)\n(6)To Cancel"); 
            out.println(); 
            int buy = console.nextInt(); 
            if(buy == 1 && hero.getClout() >= 20)
            {
                hero.setClout(hero.getClout() - 20); 
                obj.scrollText(25L,"You have bought Airpods of Introspection! This lets you See Both You & Enemy health."); 
                skillArray[0].unLock(); 
            }
            else if(buy == 1)
                obj.scrollText(25L,"You don't have enough clout!"); 
            else if(buy == 2 && hero.getClout() >= 50)
            {
                hero.setClout(hero.getClout() - 50); 
                obj.scrollText(25L,"You have bought the Aviator Glasses of Peering! This lets you Sense Enemy Stats"); 
                skillArray[1].unLock(); 
            }
            else if(buy == 2)
                obj.scrollText(25L,"You don't have enough clout!"); 
            if(buy == 3 && hero.getClout() >= 100)
            {
                hero.setClout(hero.getClout() - 100); 
                obj.scrollText(25L,"You have bought the Durag of Reflex! This lets you use Reflex Mode!"); 
                skillArray[2].unLock(); 
            }
            else if(buy == 3)
                obj.scrollText(25L,"You don't have enough clout!"); 
            if(buy == 4 && hero.getClout() >= 50)
            {
                hero.setClout(hero.getClout() - 50); 
                obj.scrollText(25L,"You have bought the Taser! This lets you Stun the Enemy"); 
                skillArray[3].unLock(); 
            }
            else if(buy == 4)
                obj.scrollText(25L,"You don't have enough clout!"); 
            if(buy == 5 && hero.getClout() >= 50)
            {
                hero.setClout(hero.getClout() - 50); 
                obj.scrollText(25L,"You have bought Glock of YWN Melly! This lets you Shoot the Enemy"); 
                skillArray[4].unLock(); 
            }
            else if(buy == 5)
                obj.scrollText(25L,"You don't have enough clout!"); 
            if(buy == 6)
                transaction = false;
            out.println(); 
            obj.scrollText(25L,"(Would you like to buy something else?\n(1)Yes or (2)No >>> "); 
            choice = console.nextInt(); 
            if(choice == 2)
                transaction = false;
        }
        obj.scrollText(25L,"Thank-you and goodbye!"); 
        out.println(); 
        out.println(); 
    }
}
