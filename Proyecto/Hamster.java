import greenfoot.*;

/**
 * Write a description of class Hamster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hamster extends Actor
{
    private int r=10;
    private int seg;
    private int ran;
    private int band=0;

    private GreenfootSound come;
    /**
     * Act - do whatever the Hamster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int n;
    public Hamster()
    {
        while(n==0)
        {
            n=Greenfoot.getRandomNumber(3);
        }
        come=new GreenfootSound("comer.wav");
    }
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        seg=mundo.dasegundos();
        move(-n);
        tambalea();
    }    

    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();
        //if(seg%2==0)
        //    mundo.addObject(this,750,ran);
        
        if(isTouching(Crank.class))
        {
            c.aumentapuntos(10);
            mundo.removeObject(this);
        }
         
        if(x<100)
        {
            come();
            c.restavidas();
            mundo.removeObject(this);
            
        }
    }
    public void tambalea()
    {
        if(Greenfoot.getRandomNumber(2000)<=100 && band==0)
        {
            turn(-10);
            band=1;
        }
        else if(Greenfoot.getRandomNumber(2000)<=100 && band==1)
        {
            turn(10);
            band=0;
        }
    }
    public void come()
    {
        come.play();
    }
}