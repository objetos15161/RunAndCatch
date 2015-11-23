import greenfoot.*;

/**
 * Write a description of class Garra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garra extends Actor
{
    /**
     * Act - do whatever the Garra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    public void act() 
    {
        move(-2);
        mejora();
    }    
    public void mejora()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();  
        x=getX();
        
        if(isTouching(Crank.class))
        {
            c.masgarra();
            c.menosvel();
            mundo.removeObject(this);
        }
        
        if(x<=100)
            mundo.removeObject(this);
        
    }
}
