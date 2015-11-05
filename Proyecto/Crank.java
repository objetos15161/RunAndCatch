import greenfoot.*;

/**
 * Write a description of class Crank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crank extends Actor
{
    /**
     * Act - do whatever the Crank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    private int y;
    public void act() 
    {
        CheckKeys();
    }    
    public void CheckKeys()
    {
        x=getX();
        y=getY();
        if (Greenfoot.isKeyDown("Down"))
        {
            setLocation(x,y+3);
        }
        else if (Greenfoot.isKeyDown("Up"))
        {
            setLocation(x,y-3);
        }
        /*else if (Greenfoot.isKeyDown("Spacebar"))
        {
            
        }*/
    }
}
