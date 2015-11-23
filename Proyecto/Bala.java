import greenfoot.*;

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound bala;
    public Bala()
    {
        bala=new GreenfootSound("bala.wav");
    }
    public void act() 
    {
        move(-5);
        mata();
    }    
    public void mata()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
 
        int x;
        x=getX();
        
        
        if(isTouching(Crank.class))
        {
            bala.play();
            c.restavidas();
            mundo.removeObject(this);
        }
         
        if(x<100)
        {
            mundo.removeObject(this);
        }
    }
}
