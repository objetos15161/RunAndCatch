import greenfoot.*;

/**
 * Clase que guarda el gif de los lobos del nivel 1
 * 
 * @oscarvelarde
 * @1 
 */
public class Lobo1 extends Lobo
{
    GifImage lobo = new GifImage("lobo1.gif");
    private int niv;
    /**
     * Hace los cambios en la imagen para la animación del lobo 1
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

        if(niv==2)
            mundo.removeObject(this);
    }
}
