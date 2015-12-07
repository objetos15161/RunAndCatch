import greenfoot.*;

/**
 * Clase de interfaz para los objetos que ademas controla su movimiento
 * 
 * @oscarvelarde 
 * @1
 */
public class Items extends Actor
{
    private int band=0;
    /**
     * Act - do whatever the Items wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    public void mover()
    {
        move(-2);
        tambalea();
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
}
