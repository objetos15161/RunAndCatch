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
    /**
     * Act - do whatever the Hamster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        b=verifica();
        move(-2);
    }    

    public int verifica()
    {
        int x;
        x=getX();
        if(x<50)
            return(1);
        
        else if(isTouching(Crank.class))
       
            return(1);
        else
            return(0);
    }
}