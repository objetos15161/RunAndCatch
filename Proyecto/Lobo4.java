import greenfoot.*;

/**
 * Clase que guarda el gif de los lobos del nivel 4
 * 
 * @oscarvelarde
 * @1 
 */
public class Lobo4 extends Lobo
{
    GifImage lobo = new GifImage("lobo4.gif");
    private int niv;
    /**
     * Hace los cambios en la imagen del lobo del nivel 4 para la animación
     */
    public void act() 
    {
        setImage(lobo.getCurrentImage());
        verifica();
    }    

    /**
     * Si termina el nivel que corresponde a este, se elimina
     */
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        niv=mundo.danivel();

        if(niv==5)
            mundo.removeObject(this);
    }
}
