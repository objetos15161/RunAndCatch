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
    private int band;
    private int y;
    private int seg=0;
    private SimpleTimer conteo;
    private int ini;
    private int mejora=0;
    private GreenfootSound garra;
    public Crank(int vidas, int puntos)
    {
        setImage("p1.png");
        garra=new GreenfootSound("garra.mp3");
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
           
           if(band==1)
           {
               garra.play();
               activa();
               band=0;
           }
           else
           {   
               garra.stop();
               desactiva();
               band=1;
           }
        }
        
    }
    public void activa()
    {
        if(mejora==1)
        { 
            setLocation(x+55,y);
            setImage("p3.png");
        }
        else if(mejora==0)
        {   
            setLocation(x+18,y);
            setImage("p2.png");
        }
    }
    public void desactiva()
    {
        if(mejora==1)
        { 
            setLocation(x-55,y);
            setImage("p1.png");
        }
        else if(mejora==0)
        {   
            setLocation(x-18,y);
            setImage("p1.png");
        }
    }

}