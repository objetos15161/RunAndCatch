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
    private int seg=0;
    private SimpleTimer conteo;
    private int i;
    private int ini;
    /*private GreenfootImage in;
    private GreenfootImage i1;
    private GreenfootImage i2;
    private GreenfootImage i3;
    private GreenfootImage i4;
    private GreenfootImage i5;
    private GreenfootImage i6;
    private GreenfootImage i7;*/
    public Crank()
    {
        /*in=new GreenfootImage("1.png");
        i1=new GreenfootImage("1.png");
        i2=new GreenfootImage("2.png"); 
        i3=new GreenfootImage("3.png"); 
        i4=new GreenfootImage("4.png"); 
        i5=new GreenfootImage("5.png"); 
        i6=new GreenfootImage("6.png"); 
        i7=new GreenfootImage("7.png"); */
        setImage("p1.png");
        conteo = new SimpleTimer();
    }
    public void act() 
    {
        CheckKeys();
        if(conteo.millisElapsed()>=500)
        {
            conteo.mark();
            seg++;
        }
    }    
    
    
    public void CheckKeys()
    {
        x=getX();
        y=getY();
        if (Greenfoot.isKeyDown("Down"))
        {
            if(y<450)
                setLocation(x,y+3);
        }
        else if (Greenfoot.isKeyDown("Up"))
        {
            if(y>120)
                setLocation(x,y-3);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            /*Greenfoot.delay(10);
            setLocation(x+5,y);
            setImage("p2.png");
            
            Greenfoot.delay(10);
            setLocation(x+7,y);
            setImage("p3.png");
            
            Greenfoot.delay(10);
            setLocation(x+9,y);
            setImage("p4.png");
            
            Greenfoot.delay(10);
            setLocation(x+11,y);
            setImage("p5.png");
            
            Greenfoot.delay(10);
            setLocation(x+13,y);
            setImage("p6.png");
            
            Greenfoot.delay(10);
            setLocation(x+17,y);
            setImage("p7.png");
            
            Greenfoot.delay(10);
            setLocation(x+13,y);
            setImage("p6.png");
            
            Greenfoot.delay(10);
            setLocation(x+11,y);
            setImage("p5.png");
            
            Greenfoot.delay(10);
            setLocation(x+9,y);
            setImage("p4.png");
            
            Greenfoot.delay(10);
            setLocation(x+7,y);
            setImage("p3.png");
            
            Greenfoot.delay(10);
            setLocation(x+5,y);
            setImage("p2.png");
            
            Greenfoot.delay(10);
            setLocation(x,y);
            setImage("p1.png");
            */
        }
        /*else if(Greenfoot.isKeyDown(32))
        {
            
        }*/
        /*else if (Greenfoot.isKeyDown("Spacebar"))
        {

        }*/
    }
    
}
/* Adventure Treasure */