
//Name: Hafi 
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;
/**
 * Randomly chooses from various scenarios for the Hero to encounter
 */
public class RandomEncounter
{
    /** 
     * constructer of RandomEncounter; cannot be instantiated. 
     */
    private RandomEncounter(){}

    /**
     * Calls for a battle, plug, or gangsta encounter and formats them
     * @param hero hero object
     * @param plug plug object
     * @param gangsta object
     */
    public static void e(Hero hero, HiddenSkill skillArray[])
    {
        ScrollText obj = new ScrollText(); 
        Scanner console = new Scanner(System.in); 
        int scenario = RNDM.i(1, 10); 
        if(skillArray[0].getState() == true)
            skillArray[0].setName("(4)LOCKED SKILL");
        else skillArray[0].setName("(4)See Health");
        if(skillArray[1].getState() == true)
            skillArray[1].setName("(5)LOCKED SKILL");
        else skillArray[1].setName("(5)Sense Enemy Stats");
        if(skillArray[2].getState() == true)
            skillArray[2].setName("\t(6)LOCKED SKILL");
        else skillArray[2].setName("(6)Reflex Mode");
        if(skillArray[3].getState() == true)
            skillArray[3].setName("(7)LOCKED SKILL");
        else skillArray[3].setName("(7)Stun Enemy");
        if(skillArray[4].getState() == true)
            skillArray[4].setName("(8)LOCKED SKILL");
        else skillArray[4].setName("(8)Shoot Enemy");
        if(skillArray[1].getState() == true && skillArray[2].getState() == false)
            skillArray[1].setName("(5)LOCKED SKILL\t");
        if(scenario >= 1 && scenario <= 4)
        {
            String enemyName = EnemyCreation.enemyName(); 
            String enemyType = EnemyCreation.enemyType(); 
            obj.scrollText(25L, "You encounter " + enemyName + " the " + enemyType + "!"); 
            obj.scrollText(100L, " "); 
            out.println();
            Enemy enemy = new Enemy("Error", 0,0,0); 
            if(enemyType == "Goon")
                enemy.changeStats(enemy,enemyName, RNDM.i(15, 20),RNDM.i(5, 10), RNDM.i(5, 10)); 
            if(enemyType == "Thug")
                enemy.changeStats(enemy,enemyName, RNDM.i(25, 30),RNDM.i(10, 20), RNDM.i(10, 20)); 
            if(enemyType == "Biker")
                enemy.changeStats(enemy,enemyName, RNDM.i(50, 55),RNDM.i(20, 30), RNDM.i(20, 30)); 
            if(enemyType == "Gang Leader")
                enemy.changeStats(enemy,enemyName, RNDM.i(75, 80),RNDM.i(30, 40), RNDM.i(30, 40)); 
            if(enemyType == "Gang Rapper")
                enemy.changeStats(enemy,enemyName, RNDM.i(80, 100),RNDM.i(40, 50), RNDM.i(40, 50)); 
            enemy.introWords(enemyType);
            Battling.fight(enemy, hero, skillArray);
        }

        else if(scenario <= 6 && scenario >= 5)
        {
            String name = EnemyCreation.enemyName(); 
            Gangsta trainer = new Gangsta(name, 0); 
            obj.scrollText(25L, "You encounter " + name + " the Gangsta!"); 
            out.println(); 
            trainer.talk(); 
            out.print("What will you do?\n(1)Talk\t(2)Trade >>> ");
            int choice = console.nextInt(); 
            console.nextLine();
            if(choice == 1)
            {
                trainer.conversation();
                out.println(); 
                obj.scrollText(25L, "You got 10 clout for listening to " + name + "'s story!"); 
                out.println(); 
                hero.setClout(hero.getClout() + 10); 
                out.print("What will you do?\n(1)Trade >>> ");
                int num = console.nextInt(); 
                console.nextLine();
                trainer.trade(hero); 
            }
            if(choice == 2)
                trainer.trade(hero); 
            out.println();
            obj.scrollText(25L, "()Enter to continue >>> "); 
            String blank = console.nextLine();
            System.out.print('\u000C');
        }
        else if(scenario >= 7 && scenario <= 10)
        {
            String name = EnemyCreation.enemyName(); 
            Plug trainer = new Plug(name, 0); 
            obj.scrollText(25L, "You encounter " + name + " the Plug!"); 
            out.println(); 
            trainer.talk(); 
            trainer.trade(hero, skillArray); 
            System.out.print('\u000C');
        }
    }
}

