import greenfoot.*;

/**
 * Write a description of class Lobo4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobo4 extends Lobo
{
    GifImage lobo = new GifImage("lobo4.gif");
    /**
     * Act - do whatever the Lobo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(lobo.getCurrentImage());
    }    
    
}
