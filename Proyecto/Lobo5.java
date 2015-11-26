import greenfoot.*;

/**
 * Clase que guarda el gif de los lobos del nivel 5
 * 
 * @oscarvelarde
 * @1 
 */
public class Lobo5 extends Lobo
{
    GifImage lobo = new GifImage("lobo5.gif");
    /**
     * Act - do whatever the Lobo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(lobo.getCurrentImage());
    }    
}
