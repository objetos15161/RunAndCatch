import greenfoot.*;

/**
 * La habilidad de este hamster es que al tocarlo, no importa lo que hagas,
 * inmovilizara al Crank por un tiempo que puede variar.
 * 
 * Esta clase hereda al ardiente un sonido que se reproduce al tocarlo.
 * 
 * @oscarvelarde
 * @1 
 */
public class Rocoso extends Hamster
{

    private int r=0;
    private GreenfootSound ral;
    /**
     * Toma una velocidad variable tambien elige el sonido que se reproduce al tocarlo
     */
    public Rocoso()
    {
        ral = new GreenfootSound("tocallamas.wav");
        while(r==0)
        {
            r=Greenfoot.getRandomNumber(3);
        }
    }

    /**
     * Realiza un movimiento normal de derecha a izquierda con tambaleo
     */
    public void act() 
    {
        verifica();
        move(-(r));
        tambalea();
    }    

    /**
     * La funcion verifica realiza la ralentizacion al Crank si es tocado, si llega al limite (resta vidas), si toca al crank(aumenta puntos)
     */
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        int x;
        x=getX();
        if(isTouching(Crank.class))
        {    
            c.ralentiza();
            quema();
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

    /**
     * Funcion que se hereda al ardiente y tambien se usa en este, reproduce el sonido al tocarlo
     */
    public void quema()
    {
        ral.play();
    }
}
