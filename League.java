import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class League here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class League
{
    private ArrayList<Division> divisions;
    
    
    /**
     * Constructor for objects of class League
     */
    public League()
    {
        divisions=new ArrayList<>();
        divisions.add(new Division("division1"));
        divisions.add(new Division("division2"));
        divisions.add(new Division("division3"));
        divisions.add(new Division("division4"));
    }

    /**
     * use a for loop to iterate over four Division instances in ArrayList divisions
     * directly call divisionDisplay method defined in  Class Division
     * leave a blank line between two divisions
     */
    
    public void displayAllDivisoins()
    {
       int i=1;
       for(Division division:divisions)
       {
         System.out.println("Division"+i);
         division.displayDivision();
         System.out.println("\n");
         i++;
       }
    }
    /**
     * just display the division that you want to see
     * directly call divisionDisplay method defined in  Class Division
     */
    public void displayWhichDivision(int whichDivision)
    {
        divisions.get(whichDivision-1).displayDivision();
    }
    
    /**
     * use for loop to setup all elements in this ArrayList.
     * directly call divisionDisplay method defined in  Class Division
     */
    public void LeagueSetup()
    {
        for(Division division:divisions)
        {
            division.divisionSetup();
        }
    
    
    }
}
