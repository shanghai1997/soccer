
/**
 * Write a description of class Coach here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coach extends Person
{
    
    private String gender;
    /**
     * Constructor for objects of class Coach
     */
    public Coach(String name,String gender)
    {
        super(name);
        this.gender=gender;
    }    

    /**
     * An example of a method - replace this comment with your own
     *
     * 
     * method to set gender
     */
    public void setGender(String newGender)
    {
        gender=newGender;
    }
}
