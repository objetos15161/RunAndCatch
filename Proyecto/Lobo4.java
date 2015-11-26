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
     * Act - do whatever the Lobo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(lobo.getCurrentImage());
        verifica();
    }    

    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        niv=mundo.danivel();

        if(niv==5)
            mundo.removeObject(this);
    }
}
