import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
/**
 * I use a MashMap to store teams, with teams'name(sampleteam.getName()) as key and class Team's instance as value. Every element is unique.
 * @author (your name)
 * @version (a version number or a date)
 */
public class Division
{
    private static String[] teamNames={"Charles","David","Wang","Meng","Zishi","Li","Zhang",
            "QI","Hua","Shen","Hua","Shanghai","Xuhui","Minghang","Ai","Shi","He","Mao"};

    private HashMap<String, Team> teamDict;
    private String name;
    private Random rand;
    private ArrayList points;

    /**
     * Constructor for objects of class division
     */
    public Division(String name)
    {
        this.name=name;
        rand=new Random();
        teamDict = new HashMap<String, Team>();

    }

    /**
     *
     * use put(key,value) to input element into this HashMap
     * 
     */
    public void addTeam(Team team)
    {
        teamDict.put(team.getName(),team);       
    }

    public Team getTeamByName(String teamName)
    {
        if(teamDict.containsKey(teamName))
        {
            return teamDict.get(teamName);
        }
        else {
            return null; //这个return type 是 Team，而不是void , 所以只可以打 return null,,,,return void 再java中不存在
        }
    }

    public HashMap<String, Team> getTeams()
    {
        return teamDict;
    }

    public int getNumberOfTeams()
    {
        return teamDict.size();
    }

    /**
     * this parameter takes four parameters,two of which are Team's instances.
     * firstly, neither team1 nor team2 can be null and goal numbers should be greater than 0.
     * when a match result is finished, the value of instance variable point, goalNumber and lostGoalNumber in teams which participate in match will be changed
     */
    public void divisionSetup()
    {
        for(int i=0;i<teamNames.length;i++)
        {
            teamDict.put(teamNames[i],new Team(teamNames[i]));
        }
        int index=0;
        int index2=0;
        int randGoalNumber=0;
        int randGoalNumber2=0;
        for(int i=0;i<30;i++){
            index=rand.nextInt(teamNames.length-1);
            index2=rand.nextInt(teamNames.length-1);
            randGoalNumber=rand.nextInt(10);
            randGoalNumber2=rand.nextInt(10);
            addAMatch(teamDict.get(teamNames[index]),randGoalNumber,teamDict.get(teamNames[index2]),randGoalNumber2);
        }

    }

    /**
     * this parameter takes four parameters,two of which are Team's instances.
     * firstly, neither team1 nor team2 can be null and goal numbers should be greater than 0.
     * when a match result is finished, the value of instance variable point, goalNumber and lostGoalNumber in teams which participate in match will be changed
     */
    public void addAMatch(Team team1,int team1Goals,Team team2,int team2Goals)
    {
        assert(team1!=null);
        assert(team2!=null);
        assert(team1Goals>=0);
        assert(team2Goals>=0);
        if(team1Goals==team2Goals)
        {
            team1.drawGame();
            team2.drawGame();   
        }

        if(team1Goals>team2Goals)
        {  
            team1.winGame();
        }

        if(team1Goals<team2Goals)
        {
            team2.winGame();
        }
            
        team1.addGoalNumber(team1Goals);
        team2.addGoalNumber(team2Goals);
        team1.addLostGoalNumber(team2Goals);
        team2.addLostGoalNumber(team1Goals);
    }
    
    /**
     * create a new local variable called ranking
     * we extract all hashMap's value in key value pair to generate a new ArrayList whose elements are a lot of team instance
     * Collections.sort(.....)
     * use a for loop to execute toString method defined in displayDivision method for list.size()-1 times
     */
    public void displayDivision()
    {
        int ranking=1;
        List<Team> list = new ArrayList<Team>(teamDict.values());
        Collections.sort(list, new Comparator() {

                public int compare(Object o1, Object o2) {

                    int point1 = ((Team) o1).getPoint();
                    int point2 = ((Team) o2).getPoint();
                    int sComp = point1-point2;

                    if (sComp != 0) {
                        return sComp;
                    } 

                    int goalDifference1 = ((Team) o1).getGoalDifference();
                    int goalDifference2 = ((Team) o2). getGoalDifference();
                    return goalDifference1-goalDifference2;
                }});
        for (int i=list.size()-1; i>0; i--){ 
            System.out.println(ranking+"  "+list.get(i).toString());
            ranking++;
        }
        System.out.println("\n");
    }

}