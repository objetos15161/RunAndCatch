import greenfoot.*;

/**
 * Clase con imagenes 800x600.
 * 
 * @oscarvelarde
 * @1 
 */
public class Presenta extends Actor
{
    private int niv;
    private int band=1;
    /**
     * Elige la imagen dependiendo del nivel actual
     */
    public Presenta()
    {
        setImage("lvl"+band+".jpg");
    }
    
    public void act()
    {
        
    }
    
    /**
     * Aumenta la bandera, que es mi indicador de nivel
     */
    public void aumenta()
    {
        band++;
        setImage("lvl"+band+".jpg");
    }
}
