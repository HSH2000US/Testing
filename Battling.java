
//Name: 
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;
/**
 * Holds code and methods for battling enemies
 */
public abstract class Battling
{
    /**
     * default constructer for battling. 
     */
    public Battling()
    {

    }

    /**
     * Code for enemy attacking hero with random value with bounds
     * @param e enemy object
     * @param h hero object
     */
    public static void enemyAttack(Enemy e, Hero h)
    {
        ScrollText obj = new ScrollText(); 
        int num = 1; 
        int damage = 0; 
        if(num == 1)
        {
            System.out.println(e.getName() + " attacks " + h.getName()); 
            damage = RNDM.i(e.getAttack()/2,e.getAttack()) - RNDM.i(h.getDefense()/5,h.getDefense()/2);
            if(damage < 0)
                damage = damage - (damage * 2); 
            if(damage == 0)
                damage = RNDM.i(1, 10);
            h.setHealth(h.getHealth() - damage); 
            obj.scrollText(25L,h.getName() + " takes " + damage + " damage!"); 
            out.println(); 
        }
    }

    /**
     * Code for hero attacking enemy with random value with bounds
     * @param e enemy object
     * @param h hero object
     */
    public static void heroAttack(Enemy e, Hero h)
    {
        ScrollText obj = new ScrollText(); 
        int num = 1;
        int damage = 0; 
        if(num == 1)
        {
            System.out.println(h.getName() + " attacks " + e.getName()); 
            damage = RNDM.i(h.getAttack()/2,h.getAttack()) - RNDM.i(e.getDefense()/5,e.getDefense()/2); 
            e.setHealth(e.getHealth() - damage); 
            obj.scrollText(25L,e.getName() + " takes " + damage + " damage!"); 
            out.println(); 
        }
    }
    
    /**
     * Code for hero attacking enemy with percentage of enemy health accounted for
     * @param e enemy object
     * @param h hero object
     * @param choice percentage of damage dealt
     */
    public static void heroAttack(Enemy e, Hero h, double choice)
    {
        ScrollText obj = new ScrollText(); 
        int damage = 0; 
        System.out.println(h.getName() + " attacks " + e.getName()); 
        damage = (int)(e.getHealth()*choice); 
        if (damage < ((int)choice * 100))
            damage = RNDM.i((int)choice * 100, 2* (int)choice * 100);
        e.setHealth(e.getHealth() - damage); 
        obj.scrollText(25L,e.getName() + " takes " + damage + " damage!"); 
        out.println(); 
    }
    
    /**
     * Code for enemy attacking hero with percentage of hero health accounted for
     * @param e enemy object
     * @param h hero object
     * @param choice percentage of damage dealt
     */
    public static void enemyAttack(Enemy e, Hero h, double choice)
    {
        ScrollText obj = new ScrollText(); 
        int damage = 0; 
        System.out.println(h.getName() + " attacks " + e.getName()); 
        damage = (int)(h.getHealth()*choice); 
        if (damage < ((int)choice * 100))
            damage = RNDM.i((int)choice * 100,2* (int)choice * 100);
        h.setHealth(h.getHealth() - damage); 
        obj.scrollText(25L,e.getName() + " takes " + damage + " damage!"); 
        out.println(); 
    }
    
    /**
     * Code for fighting between hero and enemy
     * @param e enemy object
     * @param h hero object
     * @param skillArray[] HiddenSkill array that holds all HiddenSkill objects
     */
    public static void fight(Enemy e, Hero h, HiddenSkill skillArray[])
    {
        ScrollText obj = new ScrollText(); 
        Scanner console = new Scanner(System.in); 
        boolean enemyIsStunned = false; 
        obj.scrollText(25L, "[COMBAT ENTERED]"); 
        out.print("");
        while(h.getHealth() > 0 && e.getHealth() > 0)
        {
            out.println("What will you do?\n(1)Fight\t\t(2)Run \n(3)See Your Stats\t" + skillArray[0].getName() + "\n" + skillArray[1].getName() + "\t" + skillArray[2].getName());
            out.print(skillArray[3].getName() + "\t\t" + skillArray[4].getName()); 
            int choice = console.nextInt(); 
            console.nextLine();
            out.println("__________________________________________________");
            if(choice == 1)
            {
                int n = (RNDM.i(1,3));
                if(n == 1  && enemyIsStunned == false )
                {
                    obj.scrollText(25L, "[The enemy takes initiative and attacks first!]"); 
                    out.println(); 
                    enemyAttack(e, h);
                    heroAttack(e, h);  
                    obj.scrollText(200L, " "); 
                }
                else if(n == 2 && enemyIsStunned == false)
                {
                    obj.scrollText(25L, "[You are faster than the enemy!]"); 
                    out.println(); 
                    heroAttack(e, h); 
                    enemyAttack(e, h);
                    obj.scrollText(200L, " "); 
                }
                else if((n == 3) && enemyIsStunned == false)
                    strategicAttack(e,h); 
                else if((n == 1 || n == 2 || n == 3) && enemyIsStunned == true)
                {
                    obj.scrollText(25L, "[The stunned enemy cannot attack!]"); 
                    out.println(); 
                    heroAttack(e, h); 
                    enemyIsStunned = false; 
                    obj.scrollText(25L, "[Your enemy takes the blow sent his way before jumping back to his feet no longer stunned!!]"); 
                    out.println(); 
                }
                out.println("__________________________________________________");
            }
            if(choice == 2)
            {
                int num = RNDM.i(1, 3); 
                if(num == 1)
                {
                    out.println(h.getName() + ": Ayo yo yo, mama ain't raise no crip crip but I think I'm gonna dip dip!"); 
                    obj.scrollText(25L, "[YOU RUN FROM THE FIGHT]"); 
                    out.println(); 
                    obj.scrollText(200L, " "); 
                    obj.scrollText(25L, "()Enter to continue >>> "); 
                    String blank = console.nextLine();
                    break; 
                }
                else if(num !=1)
                {
                    out.println(e.getName() + ": I see you tryna run run, haha no I ain't had my fun fun!"); 
                    obj.scrollText(25L, "[YOU FAILED TO RUN FROM THE FIGHT]");     
                    obj.scrollText(200L, " "); 
                    out.println(); 
                    enemyAttack(e, h); 
                }
                out.println("__________________________________________________");
            }
            if(choice == 3)
            {
                out.println(h); 
                out.println("__________________________________________________");
            }
            if(choice == 4 && skillArray[0].getState() == false)
            {
                out.println(h.getName() + ": " + h.getHealth() + " health"); 
                out.println(e.getName() + ": " + e.getHealth() + " health");  
                out.println("__________________________________________________\n"); 
            } 
            else if (choice == 4 && skillArray[0].getState() == true)
                out.println("Skill has not been unlocked!"); 
            if(choice == 5 && skillArray[1].getState() == false)
            {
                obj.scrollText(25L,"[Your gaze sharpens on your enemy as you analyze them]"); 
                out.println(); 
                out.println(e); 
                out.println("__________________________________________________");
            }
            else if (choice == 5 && skillArray[1].getState() == true)
                out.println("Skill has not been unlocked!"); 
            if(choice == 6 && skillArray[2].getState() == false)
            {
                obj.scrollText(25L,"[The world slows down around you as your perception and spatial awareness"); 
                out.println(); 
                obj.scrollText(25L,"are increased sixfold. Your enemy can only gape as you explode forward in a");
                out.println(); 
                obj.scrollText(25L,"blur of speed"); 
                out.println("\n__________________________________________________");
                out.println(); 
                for(int i = 0; i < 6; i ++)
                {
                    heroAttack(e, h); 
                    out.println(); 
                }
            }
            else if (choice == 6 && skillArray[2].getState() == true)
                out.println("Skill has not been unlocked!"); 
            if(choice == 7 && skillArray[3].getState() == false)
            {
                obj.scrollText(25L,"You leap forward and taze the enemy, stunning them!"); 
                out.println(); 
                enemyIsStunned = true; 
                heroAttack(e, h); 
            }
            else if (choice == 7 && skillArray[3].getState() == true)
                out.println("Skill has not been unlocked!"); 
            if(choice == 8 && skillArray[4].getState() == false)
            {
                obj.scrollText(25L,"You whip out your glock and shoot your adversary!"); 
                out.println(); 
                heroAttack(e, h, .5); 
                int restore = RNDM.i(5, 20); 
                for(int i = 0; i < 3; i++)
                {
                    obj.scrollText(100L, "...");
                    System.out.print('\u000C');
                }
                obj.scrollText(25L,"Murder On [Your] Mind activates self regeneration! " + restore + " health restored!"); 
                h.setHealth(h.getHealth() + restore); 
                out.println(); 
                enemyAttack(e, h); 
            }
            else if (choice == 8 && skillArray[4].getState() == true)
                out.println("Skill has not been unlocked!"); 
            obj.scrollText(25L, "()Enter to continue >>> "); 
            String blank = console.nextLine();
            System.out.print('\u000C');
            for(int i = 0; i < 3; i++)
            {
                obj.scrollText(100L, "...");
                System.out.print('\u000C');
            }
        }
        if(e.getHealth() <= 0)
        {
            e.lastWords();
            obj.scrollText(25L,"You have killed " + e.getName() + "!"); 
            out.println(); 
            obj.scrollText(25L,"You got " + e.getAttack() + " Clout!"); 
            h.setClout(h.getClout() + e.getAttack()); 
            obj.scrollText(1000L, " "); 
        }
        System.out.print('\u000C');
    }
    
    /**
     * Randomizes a scenario in fight between hero and enemy
     * @param h hero object
     * @param e enemy object 
     */
    public static void strategicAttack(Enemy e, Hero h)
    {
        ScrollText obj = new ScrollText(); 
        Scanner console = new Scanner(System.in); 
        obj.scrollText(25L,e.getName() + " rushes at you in a blind rage, throwing his body to knock you down,"); 
        out.println(); 
        obj.scrollText(25L, "leaving him vulnerable for a split second."); 
        out.println();
        String[] bodyParts = new String[]{"Crotch", "Legs", "Torso", "Neck", "Head"};
        int num = RNDM.i(1,5);
        obj.scrollText(25L, "[You can attack the following areas for varying effects]: \n");
        for(int i = 0; i < num; i++)
        {
            out.print("(" + (i + 1) + ")[" + bodyParts[i] + "]  "); 
        }
        obj.scrollText(25L, "[What will you do] >>>"); 
        num = console.nextInt(); 
        console.nextLine();
        if(num == 1)
        {
            num = RNDM.i(1,2); 
            if(num == 1)
            {
                obj.scrollText(25L,"You wait until your assailant is upon you before jumping back and to the");  
                out.println();
                obj.scrollText(25L,"side, sending him stumbling. Your arms snap out to grab his wrists and");
                out.println();
                obj.scrollText(25L,"pull his off-balance body towards you, violently slamming your knee between");
                out.println(); 
                obj.scrollText(25L,"his legs, unfortunately missing his gonads but striking his pelvic girdle!");
                out.println(); 
                heroAttack(e,h, .1); 
            }
            else if(num == 2)
            {
                obj.scrollText(25L,"You wait until your assailant is upon you before jumping back and to the");  
                out.println();
                obj.scrollText(25L,"side, sending him stumbling. Your arms snap out to grab his wrists and");
                out.println();
                obj.scrollText(25L,"pull his off-balance body towards you, violently slamming your knee between");
                out.println(); 
                obj.scrollText(25L,"his legs, brutally smashing itno his gonads with a sickening *squelch*!");
                out.println(); 
                heroAttack(e,h, .2); 
            }
        }     
        else if(num == 2)
        {
            num = RNDM.i(1,2); 
            if(num == 1)
            {
                obj.scrollText(25L,"Your opponent rushes at you in a wild frenzy, not caring for your reaction!");  
                out.println();
                obj.scrollText(25L,"This is quickly exploited as you slide forward to the ground and sweep your leg");
                out.println();
                obj.scrollText(25L,"in a wide arc, sending him careening to the floor!");
                out.println(); 

                heroAttack(e,h, .15); 
            }
            else if(num == 2)
            {
                obj.scrollText(25L,"Your opponent rushes at you in a wild frenzy, not caring for your reaction!");  
                out.println();
                obj.scrollText(25L,"You attempt to exploit this as you slide forward to the ground and sweep your leg");
                out.println();
                obj.scrollText(25L,"in a wide arc. He suddenly stops in his charge as you do this, your foot landing");
                out.println(); 
                obj.scrollText(25L,"laughably short of doing anything. He looks at you like you're stupid and brutally");
                out.println();
                obj.scrollText(25L,"smacks you across the face like your mama would when she BIG mad!");
                out.println();
                enemyAttack(e,h, .15); 
            }
        }    
        else if(num == 3)
        {
            num = RNDM.i(1, 1); 
            if(num == 1)
            {
                obj.scrollText(25L,"You challenge fire with fire by exploding forward to meet him, fists raised");
                out.println();
                obj.scrollText(25L,"in a traditional boxing stance, weaving in and out of his frenzied punches,");
                out.println();
                obj.scrollText(25L,"before stepping into his guard and raining a series of calculated jabs, crosses,");
                out.println(); 
                obj.scrollText(25L,"and hooks across his body!");
                out.println(); 
                for(int i = 0;  i < 4; i++)
                {
                    heroAttack(e,h); 
                    out.println(); 
                }
            }
        } 
        else if(num == 4)
        {
            num = RNDM.i(1,2); 
            if(num == 1)
            {
                obj.scrollText(25L,"You explode forward in a blur of speed, surprising your enemy momentarily"); 
                out.println();
                obj.scrollText(25L,"into stumbling, which is all you need. Your fist slams into your opponent");
                out.println();
                obj.scrollText(25L,"as you crush his windpipe, wounding him grieviously!");
                out.println(); 
                heroAttack(e,h, .50);   
            }
            else if(num == 2)
            {
                obj.scrollText(25L,"You explode forward in a blur of speed, surprising your enemy momentarily");  
                out.println();
                obj.scrollText(25L,"into stumbling. Your opponent catches himself and jukes around you,");
                out.println();
                obj.scrollText(25L,"whipping out a switchblade and ramming it between your ribs, ");
                out.println(); 
                obj.scrollText(25L,"grieviously wounding you and thwarting your attempt to counter!");
                out.println();
                enemyAttack(e,h, .50); 
            }
        }
        else if(num == 5)
        {
            num = RNDM.i(1,2); 
            if(num == 1)
            {
                obj.scrollText(25L,"You juke around your assailant and rush into him from the side in a full-bodied"); 
                out.println();
                obj.scrollText(25L,"tackle, pinning him to the ground in a brutalistic fashion. You feel him thrash");
                out.println();
                obj.scrollText(25L,"around as he grabs something from his pocket and flicks his wrist to result in a");
                out.println(); 
                obj.scrollText(25L,"*clicking* noise. Knowing what it is your hand instinctively reaches out to wrench");
                out.println(); 
                obj.scrollText(25L,"it from his grip, before messily slamming the switchblade into the side of his head!");
                out.println(); 
                e.setHealth(0);  
            }
            else if(num == 2)
            {
                obj.scrollText(25L,"You juke around your assailant and rush into him from the side in a full-bodied"); 
                out.println();
                obj.scrollText(25L,"tackle, pinning him to the ground in a brutalistic fashion. You feel him thrash");
                out.println();
                obj.scrollText(25L,"around as he reaches into his pocket and subtly flicks his wrist to result in a");
                out.println(); 
                obj.scrollText(25L,"*clicking* noise. You helplessly try to wrench it from his grip, knowing full well");
                out.println(); 
                obj.scrollText(25L,"what it is, but fail to do so as he rams his switchblade into your heart!");
                out.println(); 
                h.setHealth(0); 
            }
        }
    }
}
