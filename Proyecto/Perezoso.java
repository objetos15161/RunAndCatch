import greenfoot.*;

/**
 * Write a description of class Perezoso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Perezoso extends Hamster
{
    /**
     * Act - do whatever the Perezoso wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dir=-1;
    private int band=0;
    private int ran;
    private int seg;
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        seg=mundo.dasegundos();
        move(dir);
        tambalea();
    }    
    public void mueve()
    {
        int x;
        x=getX();
        if(x<=400 && band==0)
        {
            band=1;
            setImage("normal.png");
            dir=2;
        }
        else if(band==1 && x>=600)
        {   
            setImage("perezoso.png");
            dir=-2;
        }    
    }
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();
        mueve();
        if(seg%2==0)
            mundo.addObject(this,750,ran);
        
        if(isTouching(Crank.class))
        {
            mundo.removeObject(this);
        }
        
        if(seg==59)
        {  
            mundo.removeObject(this);
        }
            
        if(x<100)
            mundo.removeObject(this);
                    
    }
}
