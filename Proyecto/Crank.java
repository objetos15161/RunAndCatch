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
    
    private SimpleTimer conteo;
    
    private GreenfootImage in;
    private GreenfootImage i1;
    private GreenfootImage i2;
    private GreenfootImage i3;
    private GreenfootImage i4;
    private GreenfootImage i5;
    private GreenfootImage i6;
    private GreenfootImage i7;
    public Crank()
    {
        in=new GreenfootImage("1.png");
        i1=new GreenfootImage("1.png");
        i2=new GreenfootImage("2.png"); 
        i3=new GreenfootImage("3.png"); 
        i4=new GreenfootImage("4.png"); 
        i5=new GreenfootImage("5.png"); 
        i6=new GreenfootImage("6.png"); 
        i7=new GreenfootImage("7.png"); 
        conteo = new SimpleTimer();
    }
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
        int i;
        for(i=1;i<7;i++)
        {
            if(conteo.millisElapsed()>=1000)
                conteo.mark();
            setImage(i+".png");
        }
        for(i=7;i>0;i--)
        {
            if(conteo.millisElapsed()>=1000)
                conteo.mark();
            setImage(i+".png");
        }
    }
}
