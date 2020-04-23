import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
/**
 * use an HashSet to store instances of Player class and you dont need to worry that repeated element will be in this HashSet.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team 
{
    private String name;
    private int point;
    private HashSet<Player> players;// no duplication
    private Coach coach;
    private Random rand;
    private int goalNumber;
    private int lostGoalNumber;
    /**
     * Constructor for objects of class team
     * Assign values to all instance variables of class Team
     */
    public Team(String name)
    {
        this.name=name;
        this.coach=coach;
        players=new HashSet<>();
        rand=new Random();
        point=0;
        goalNumber=0;
        lostGoalNumber=0;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void setCoach(Coach coachName)
    {
        coach=coachName;
    }

    public String getName()
    {
        return name;
    }

    public int getPoint()
    {
        return point;
    }

    public void winGame()
    {
        point=point+3;
    }

    public void drawGame()
    {
        point++;
    }

    public void loseGame()
    {
        point=point+0;
    }

    public void addGoalNumber(int goalsAchieved)
    {
        goalNumber=goalNumber+goalsAchieved;
    }

    public void addLostGoalNumber(int goalsLost)
    {
        lostGoalNumber=lostGoalNumber+goalsLost;
    }

    public int getGoalDifference()
    {
        return goalNumber-lostGoalNumber;
    }

    public String toString(){
        return name+" Point: "+point+"  "+" Goal Difference: "+getGoalDifference();
    }
    
} 