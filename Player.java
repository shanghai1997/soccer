
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Person
{
    
    private int number;
    
     /**
     * 
     */
    public Player(String name,int number)
    {
        super(name);
        this.number=number;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNumber()
    {
        return number;
    }
}
