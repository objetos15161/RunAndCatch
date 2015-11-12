import greenfoot.*;

/**
 * Write a description of class Ardiente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ardiente extends Rocoso
{
    /**
     * Act - do whatever the Ardiente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int b;
    public void act() 
    {
        b=verifica();
        move(-5);
    }    
}
