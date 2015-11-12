import greenfoot.*;

/**
 * Write a description of class Crank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crank extends Actor
{
    /**
     * Act - do whatever the Crank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    private int y;
    
    private SimpleTimer reloj;
    
    public void act() 
    {
        CheckKeys();

    }    

    public void CheckKeys()
    {
        x=getX();
        y=getY();
        if (Greenfoot.isKeyDown("Down"))
        {
            setLocation(x,y+3);
        }
        else if (Greenfoot.isKeyDown("Up"))
        {
            setLocation(x,y-3);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            animacion();
        }
        /*else if(Greenfoot.isKeyDown(32))
        {
            
        }*/
        /*else if (Greenfoot.isKeyDown("Spacebar"))
        {

        }*/
    }
    public void animacion()
    {
       /* int i;
        for(i=0;i<7;i++)
        {
            if(reloj.millisElapsed()>100)
            {
                reloj.mark();
                setImage(i+".png");
            }
        }
        for(i=7;i>0;i--)
        {
            if(reloj.millisElapsed()>100)
            {
                reloj.mark();
                setImage(i+".png");
            }
        }*/
    }
}
