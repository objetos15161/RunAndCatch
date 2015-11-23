import greenfoot.*;

/**
 * Write a description of class Ardiente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ardiente extends Rocoso
{
    /**
     * Act - do whatever the Ardiente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer reloj;
    private int band=0;
    private int ran;
    private GreenfootSound ral;
    public Ardiente()
    {
        ral = new GreenfootSound("tocallamas.wav");
        reloj=new SimpleTimer();
        setImage("ardiente1.png");
    }
    
    public void act() 
    {
        if(band==0 && reloj.millisElapsed()>=800)
        {
            setImage("ardiente.png");
            reloj.mark();
            band=1;
        }
        else if(band==1 && reloj.millisElapsed()>=1000)
        {
            setImage("ardiente1.png");
            reloj.mark();
            band=0;
        }   
        verifica();
        move(-2);
        tambalea();
    }    
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();

    
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();
        
        if(isTouching(Crank.class) && band==0)
        {    
            ral.play();
            c.ralentiza();
            c.aumentapuntos(10); 
            mundo.removeObject(this);
        }
        else if(isTouching(Crank.class) && band==1)
        {
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
