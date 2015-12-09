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
     * Hace los cambios en la imagen del lobo de nivel 5, a diferencia del resto, este no se
     * elimina ya que es el ultimo
     * */
    public void act() 
    {
        setImage(lobo.getCurrentImage());
    }    
}
