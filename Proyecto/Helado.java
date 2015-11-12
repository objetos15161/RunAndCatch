import greenfoot.*;

/**
 * Write a description of class Helado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helado extends Hamster
{
    private int b;
    /**
     * Act - do whatever the Helado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       b=verifica();
       move(-5);
    }    
}
