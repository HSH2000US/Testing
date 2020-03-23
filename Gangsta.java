
//Name: 
import java.util.*;
import static java.lang.System.*;
/**
 * GangstaTrainer class, an NPC that can trade and talk with Hero
 */
public class Gangsta extends NPC
{
    //Please add constructors to your NPC class, else this class doesn't work
    /**
     * Constructs a Gangsta
     * @param n the name of the NPC
     * @param h the health of the NPC (Character requires this)
     */
    public Gangsta(String n, int h){
        super(n,h);
    }

    /**
     * Displays a conversation between the GangstaTrainer and the Hero
     */
    public void talk(){
        ScrollText obj = new ScrollText(); 
        obj.scrollText(25L, getName() + ": \"Your boi got the goods, dropping straight fire in da hood\"");
        out.println(); 
        obj.scrollText(25L, "\"Of course, you gonna need the clout to be able to cop right now\"");
        out.println(); 
    }

    /**
     * Allows the Hero to trade clout for attack and defense. The Hero can decline the offer as well.
     * @param hero the Hero the GangstaTrainer will trade with
     */
    public void trade(Hero hero){
        Scanner keyboard = new Scanner(System.in);
        ScrollText obj = new ScrollText(); 
        int attack = RNDM.i(10,20);
        int defense = RNDM.i(10,20);
        int c = RNDM.i(10,20);
        obj.scrollText(25L,"\"I can trade you " + attack + " attack and " + defense + " defense for " + c + " clout.\"");
        out.println(); 
        if (hero.getClout()>= c){
            obj.scrollText(25L,"You can (1)Accept offer (2)Decline offer ");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            if (choice==1){
                ((BattleCharacter)(hero)).setAttack(((BattleCharacter)(hero)).getAttack()+attack);
                ((BattleCharacter)(hero)).setDefense(((BattleCharacter)(hero)).getDefense()+defense);
                hero.setClout(hero.getClout()-c);
                obj.scrollText(25L,"You have successfully traded!");
                out.println(); 
                obj.scrollText(25L,"That's all I have to offer at the moment!");
            }
            else if (choice==2)
                obj.scrollText(25L,"You declined the offer.");
        }
        else
            obj.scrollText(25L,"\"\n...wait, no, you broke. Get more clout before trading with me, yo!\"");
        out.println(); 
    }

    /**
     * Allows the Hero to coverse with the Gangsta and ask for his backstory for 3 potential backstories. 
     * Gives 10 clout anytime the hero listens to the Gangsta
     */
    public void conversation(){
        ScrollText obj = new ScrollText(); 
        Scanner console = new Scanner(System.in); 
        obj.scrollText(25L, getName() + ": \"Hmm you want to know more about me, ayo?\"");
        out.println(); 
        obj.scrollText(25L, "\"Learn about my life and you finna be impressed fo' sure!\"");
        out.println(); 
        switch (RNDM.i(0, 2))
        {
            case 0  : 
            obj.scrollText(25L, "\"To be honest, not much to say though, used to be a high school basketball coach\"");
            out.println(); 
            obj.scrollText(25L, "\"See I owed money to some sharks bro, so I ran from the opps to live my life here, yo. \"");
            out.println(); 
            break;
            case 1  : 
            obj.scrollText(25L, "\"As a boy I always felt like no one listened to me, that's how I grew up\"");
            out.println(); 
            obj.scrollText(25L, "\"Church is where I found God, but it's also where I learned to judge\"");
            out.println();
            obj.scrollText(25L, "\"A man of God I became, but I grew sick of the hypocrisy\"");
            out.println();
            obj.scrollText(25L, "\"I felt like religion was a disease, it lost its appeal to me\"");
            out.println();
            obj.scrollText(25L, "\"So I left everything behind for the hood, and finally set my soul free\"");
            out.println();
            break; 
            case  2: 
            obj.scrollText(25L, "\"I spent my life in the projects\"");
            out.println(); 
            obj.scrollText(25L, "\"Mama saying I was up next\"");
            out.println(); 
            obj.scrollText(25L, "\"Always tryna rob yeah\"");
            out.println(); 
            obj.scrollText(25L, "\"I didn't even touch a gun yet\"");
            out.println(); 
            obj.scrollText(25L, "\"Most the folk I grew up with\"");
            out.println();
            obj.scrollText(25L, "\"Are sitting up, or either gone, yeah\"");
            out.println();
            break;
        } 
    }
}
