import greenfoot.*;

/**
 * Write a description of class Rocoso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocoso extends Hamster
{
    /**
     * Act - do whatever the Rocoso wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int r=0;
    private GreenfootSound ral;
    public Rocoso()
    {
        ral = new GreenfootSound("tocallamas.wav");
        while(r==0)
        {
            r=Greenfoot.getRandomNumber(3);
        }
    }
    public void act() 
    {
        verifica();
        move(-(r));
        tambalea();
    }    
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        int x;
        x=getX();
        if(isTouching(Crank.class))
        {    
            ral.play();
            c.ralentiza();
            c.aumentapuntos(15);
            mundo.removeObject(this);
        }
        
        if(x<100)
        {
            come();
            c.restavidas();
            mundo.removeObject(this);
        }
    } 
}
