import greenfoot.*;

/**
 * Write a description of class ArenaScroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArenaScroll extends Actor
{
    /**
     * Act - do whatever the ArenaScroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(-9);
    }    
    public int verifica()
    {
        if(getX()<10)
            return(1);
        else
            return(0);
    }
}
