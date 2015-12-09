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

    /**
     * Se encarga del movimiento de la bala y de llamar la funcion que valida si toco al personaje
     */
    public void act() 
    {
        move(-5);
        mata();
    }    

    /**
     * Se encarga de validar si toca al personaje y le baja una vida en caso de hacerlo
     */
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
