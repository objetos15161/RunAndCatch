import greenfoot.*;

/**
 * Write a description of class Vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Actor
{
    /**
     * Act - do whatever the Vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    public void act() 
    {
        move(-4);
        limite();
    }    
    public void limite()
    {
        RunWorld mundo = (RunWorld)getWorld();
        x=getX();
        if(x<100)
        {
            mundo.removeObject(this);
        }
    }
}
