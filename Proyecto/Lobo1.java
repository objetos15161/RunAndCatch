import greenfoot.*;

/**
 * Write a description of class Lobo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobo1 extends Lobo
{
    GifImage lobo = new GifImage("lobo1.gif");
    private int niv;
    /**
     * Act - do whatever the Lobo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        verifica();

    }    
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        niv=mundo.danivel();
        
        if(niv==2)
            mundo.removeObject(this);
    }
}
