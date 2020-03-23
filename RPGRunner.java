
//Name: Hafi Ansari
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;
/**
 * Backbone of game, where Hero object instantiated and runner/main method called
 */
public class RPGRunner
{
    /**
     * Main method & runner of entire program. Hero Object and HiddenSkill objects instantiated here. 
     * RandomEncounter called here
     */
    public static void main(String[] args)
    {
        ScrollText obj = new ScrollText(); 
        Scanner console = new Scanner(System.in); 
        HiddenSkill[] skillArray; 
        skillArray = new HiddenSkill[5]; 
        HiddenSkill four = new HiddenSkill(4, "(4)See Health", "Airpods of Introspection", true); 
        HiddenSkill five = new HiddenSkill(5, "(5)Sense Enemy Stats", "Aviator Glasses of Peering", true); 
        HiddenSkill six = new HiddenSkill(6, "(6)Reflex Mode", "Durag of Reflex", true); 
        HiddenSkill seven = new HiddenSkill(7, "(7)Stun Enemy", "Taser of Ouch", true); 
        HiddenSkill eight = new HiddenSkill(8, "(8)Shoot Enemy","Glock of YWN MellY", true); 
        skillArray[0] = four; 
        skillArray[1] = five; 
        skillArray[2] = six; 
        skillArray[3] = seven; 
        skillArray[4] = eight; 
        out.println("Welcome to Chicago Wars\n");     
        out.println("__________________________________________________"); 
        obj.scrollText(50L, "Location: Chicago Illinois"); 
        out.println(); 
        obj.scrollText(25L, "Date: September 2019"); 
        out.println(); 
        obj.scrollText(25L, "Time: 12:00\n");  
        out.println("__________________________________________________"); 
        out.print("Enter your name >>> ");
        String name = console.nextLine(); 
        Hero hero = new Hero(name, 100, 10, 10, 50); 
        out.println("Welcome " + name + "! Here are your stats!");
        out.println(hero); 
        out.println(name + "! You are about to enter a journey that will span"); 
        out.println("across the entirety of the city. Press enter when you are ready!"); 
        String blank = console.nextLine();
        System.out.print('\u000C'); 
        while(hero.getHealth() > 0)
        {
            RandomEncounter.e(hero, skillArray); 
        }
        out.println("GAME OVER! " + name + " is dead"); 
    }
}
