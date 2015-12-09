import greenfoot.*;

/**
 * Clase de interfaz, hereda a sus subclases el sonido come(que se ejectua al
 * llegar al borde izquierdo) y la funcion tambalea la cual simula que los 
 * hamsters están corriendo o caminando de una manera peculiar.
 * 
 * La funcion verifica es diferente en las subclases ya que la validacion
 * al tocar al Crank puede cambiar.
 * 
 * La cantidad de puntos que otrogan es variable.
 * 
 * @oscarvelarde
 * @1 
 */
public class Hamster extends Actor
{
    private int r=10;
    private int seg;
    private int ran;
    private int band=0;

    private GreenfootSound come;
    private int n;
    /**
     * EL constructor toma un numero random el cual será la velocidad
     * de movimiento durante todo el trayecto del hamster
     */
    public Hamster()
    {
        while(n==0)
        {
            n=Greenfoot.getRandomNumber(3);
        }
        come=new GreenfootSound("comer.wav");
    }

    /**
     * Realiza el movimiento, y manda a llamar la funcion verifica
     */
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        move(-n);
        tambalea();
    }    

    /**
     * Se encarga de verificar si el hamster llego al limite (quita una vida), tocó al personaje  (aumenta puntos)
     */
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();

        if(isTouching(Crank.class))
        {
            c.aumentapuntos(10);
            mundo.removeObject(this);
        }

        if(x<100)
        {
            come();
            c.restavidas();
            mundo.removeObject(this);

        }
    }

    /**
     * Metodo que se hereda a sus clases, simula un pequeño tambaleo
     */
    public void tambalea()
    {
        if(Greenfoot.getRandomNumber(2000)<=100 && band==0)
        {
            turn(-10);
            band=1;
        }
        else if(Greenfoot.getRandomNumber(2000)<=100 && band==1)
        {
            turn(10);
            band=0;
        }
    }

    /**
     * Metodo que se hereda al resto de los hamsters, reproduce el sonido de ser comido por un lobo
     */
    public void come()
    {
        come.play();
    }
}