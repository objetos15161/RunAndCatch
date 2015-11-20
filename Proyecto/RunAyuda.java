import greenfoot.*;

/**
 * Write a description of class RunAyuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunAyuda extends World
{

    /**
     * Constructor for objects of class RunAyuda.
     * 
     */
    private int cuenta;
    private GreenfootSound ayuda;
    public RunAyuda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        ayuda=new GreenfootSound ("instru.mp3");
    }
    public void act()
    {
        ayuda.play();
        setBackground("ayuda1.JPG");
        Greenfoot.delay(400);
        setBackground("ayuda2.JPG");
        Greenfoot.delay(400);   
        setBackground("ayuda3.JPG");
        Greenfoot.delay(400);
        setBackground("ayuda4.JPG");
        Greenfoot.delay(400);
        ayuda.stop();
        Greenfoot.setWorld(new Menu());
                
    }
}
