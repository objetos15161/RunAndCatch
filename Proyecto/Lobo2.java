import greenfoot.*;

/**
 * Clase que guarda el gif de los lobos del nivel 2
 * 
 * @oscarvelarde
 * @1 
 */
public class Lobo2 extends Lobo
{
    GifImage lobo = new GifImage("lobo2.gif");
    private int niv;
    public void act() 
    {
        setImage(lobo.getCurrentImage());
        verifica();
    }    

    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        niv=mundo.danivel();

        if(niv==3)
            mundo.removeObject(this);
    }
}
