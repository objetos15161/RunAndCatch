import greenfoot.*;

/**
 * Clase que guarda el gif de los lobos del nivel 3
 * 
 * @oscarvelarde
 * @1 
 */
public class Lobo3 extends Lobo
{
    GifImage lobo = new GifImage("lobo3.gif");
    private int niv;
    /**
     * Hace los cambios en la imagen para la animacion del lobo de nivel 3
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

        if(niv==4)
            mundo.removeObject(this);
    }
}
