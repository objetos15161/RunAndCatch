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

    public void act() 
    {

    }    

    /**
     * Funcion para el movimiento de las subclases de esta clase
     */
    public void mover()
    {
        move(-2);
        tambalea();
    }

    /**
     * Hace un movimiento para las subclases de esta
     */
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
