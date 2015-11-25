import greenfoot.*;

/**
 * Objeto que sirve para dar mas vida al personaje principal del 
 * juego, las validaciones se ecuentran en la clase Crank
 * 
 * @oscarvelarde
 * @1 
 */
public class Vida extends Actor
{
    /**
     * Se mueve de derecha a izquierda y al llegar al otro extremo
     * desaparece.
     */
    private int x;
    public void act() 
    {
        move(-4);
        limite();
    }    
    public void limite()
    {
        RunWorld mundo = (RunWorld)getWorld();
        x=getX();
        if(x<100)
        {
            mundo.removeObject(this);
        }
    }
}
