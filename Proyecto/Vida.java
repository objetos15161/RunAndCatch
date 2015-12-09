import greenfoot.*;

/**
 * Objeto que sirve para dar mas vida al personaje principal del 
 * juego, las validaciones se ecuentran en la clase Crank
 * 
 * @oscarvelarde
 * @1 
 */
public class Vida extends Items
{
    
    private int x;
    /**
     * Al aparecer se mueve de derecha a izquierda 
     */
    public void act() 
    {
        move(-4);
        limite();
    }    

    /**
     * Al llegar al extremo del mapa se elimina
     */
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
