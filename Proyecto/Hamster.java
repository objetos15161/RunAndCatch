import greenfoot.*;

/**
 * Write a description of class Hamster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hamster extends Actor
{
    private int b;
    private int r=10;
    private int seg;
    private int ran;
    /**
     * Act - do whatever the Hamster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        b=verifica();
        seg=mundo.dasegundos();
        move(-1);
    }    

    public int verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();
        if(seg%2==0)
            mundo.addObject(this,750,ran);
        
        if(x<50)
            mundo.removeObject(this);
        
        else if(isTouching(Crank.class))
            return(1);
        return(0);
    }
    
}