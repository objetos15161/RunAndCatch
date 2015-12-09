import greenfoot.*;

/**
 * Mundo que muestra una secuencia de imagenes con fondo musical, muestra y explica el funcionamiento y conceptos basicos del juego
 * 
 * @oscarvelarde
 * @1
 */
public class RunAyuda extends World
{

    /**
     * Constructor del mundo ayuda.
     * 
     */
    private int cuenta;
    private GreenfootSound ayuda;
    /**
     * Se define el tamaño que es el standar en cada una de las pantallas y una musica de fondo
     */
    public RunAyuda()
    {    
       
        super(800, 600, 1); 
        ayuda=new GreenfootSound ("instru.mp3");
    }

    /**
     * Muestra en pantalla una secuencia de imagenes que explican brevemente el fin y funcionamiento del juego
     */
    public void act()
    {
        ayuda.play();
        setBackground("ayuda1.JPG");
        Greenfoot.delay(300);
        setBackground("ayuda2.JPG");
        Greenfoot.delay(300);   
        setBackground("ayuda3.JPG");
        Greenfoot.delay(300);
        setBackground("ayuda4.JPG");
        Greenfoot.delay(300);
        ayuda.stop();
        Greenfoot.setWorld(new Menu());

    }
}
