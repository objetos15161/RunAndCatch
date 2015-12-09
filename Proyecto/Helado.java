import greenfoot.*;

/**
 * Este actor tiene la peculiaridad de tener un escudo, el cual es la imagen que tiene
 * al aparecer en la pantalla, para atraparlo debes tocar con el crank 2 veces.
 * 
 * Al tocar el escudo se escucha un sonido similiar a romper un vidrio.
 * 
 * @oscarvelarde
 * @1 
 */
public class Helado extends Hamster
{
    private GreenfootSound rompe;
    private int seg;
    private int ran;
    private int vel=-2;
    private int band=0;
    /**
     * Elige el sonido que se reproducira en caso de tocar al hamster cuando tiene 
     * el contorno azul, el cual, simboliza un escudo de hielo
     */
    public Helado()
    {
        rompe=new GreenfootSound("rompe.wav");
    }

    /**
     * Toma del mundo los segundos actuales y usa los metodos de su superclase
     */
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        seg=mundo.dasegundos();
        tambalea();
        move(vel);
    }    

    /**
     * Se encarga de verificar si el hamster llego al limite (quita una vida), tocó al personaje  (aumenta puntos), si tiene el aura azul
     * y es tocado reproduce el sonido de romper, y corre hacia adelante esperando ser atrapado de nuevo
     */
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        ran=Greenfoot.getRandomNumber(600);
        int x;
        int y;
        x=getX();
        y=getY();
        if(seg%2==0)
            mundo.addObject(this,750,ran);

        if(x>=600 && band==1)
            vel=-2;

        if(isTouching(Crank.class) && band==0)
        {
            rompe.play();
            vel=10;

            //this.setLocation(x+200,y);
            band=1;
            this.setImage("helado.png");
        }

        else if(isTouching(Crank.class) && band==1)
        {
            c.aumentapuntos(20);
            mundo.removeObject(this);
        }

        if(x<100)
        {
            come();
            c.restavidas();
            mundo.removeObject(this);
        }
    }

}
