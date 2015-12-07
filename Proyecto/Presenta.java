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
    public Presenta()
    {
        setImage("lvl"+band+".jpg");
    }
    public void act()
    {
        
    }
    public void aumenta()
    {
        band++;
        setImage("lvl"+band+".jpg");
    }
}
