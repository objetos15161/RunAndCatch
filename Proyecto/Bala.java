import greenfoot.*;

/**
 * Objeto que al tocar al Crank, le resta una vida.
 * Si lo toca, o llega al otro extremo desaparece.
 * 
 * @oscarvelarde
 * @1 
 */
public class Bala extends Actor
{
    /**
     * Se mueve de derecha a izquierda en el mapa.
     * Si toca al actor Crank, le resta una vida y reproduce un sonido
     * para indicar que toco al actor.
     */
    private GreenfootSound bala;
    public Bala()
    {
        bala=new GreenfootSound("bala.wav");
    }

    public void act() 
    {
        move(-5);
        mata();
    }    

    public void mata()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   

        int x;
        x=getX();

        if(isTouching(Crank.class))
        {
            bala.play();
            c.restavidas();
            mundo.removeObject(this);
        }

        if(x<100)
        {
            mundo.removeObject(this);
        }
    }
}
