import greenfoot.*;

/**
 * La caracteristica de este hamster, es que cambia su imagen, pero
 * no solo eso, si se toca cuando esta "en llamas" ralentiza al Crank
 * 
 * Los puntos que recibas depende si lo tocas cuando esta en llamas o no.
 * @oscarvelarde
 * @1 
 */
public class Ardiente extends Rocoso
{
    /**
     * La diferecia es la bandera que indica si esta encendido y apagado,
     * y en base a esto ralentiza o no al Crank.
     */
    private SimpleTimer reloj;
    private int band=0;
    private int ran;

    public Ardiente()
    {
        reloj=new SimpleTimer();
        setImage("ardiente1.png");
    }

    public void act() 
    {
        //despues de un lapso de tiempo normaliza al hamster
        if(band==0 && reloj.millisElapsed()>=800)
        {
            setImage("ardiente.png");
            reloj.mark();
            band=1;
        }
        /*esto cambia la imagen a otro hamster identico
        pero con un aura roja*/
        else if(band==1 && reloj.millisElapsed()>=1000)
        {
            setImage("ardiente1.png");
            reloj.mark();
            band=0;
        }   
        verifica();
        move(-2);
        tambalea();
    }    

    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();

        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();

        if(isTouching(Crank.class) && band==0)
        {    
            quema();
            c.ralentiza();
            c.aumentapuntos(10); 
            mundo.removeObject(this);
        }
        else if(isTouching(Crank.class) && band==1)
        {
            c.aumentapuntos(15);
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
