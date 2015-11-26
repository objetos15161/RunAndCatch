import greenfoot.*;

/**
 * La peculiaridad de este hamster es que al llegar a una zona del mapa
 * cambia su movimiento y comienza a avanzar a la derecha, poco despues 
 * vuelve a desplazarse a la izquierda.
 * 
 * @oscarvelarde
 * @1 
 */
public class Perezoso extends Hamster
{
    /**
     * La variable direccion cambia al hacer la validacion, que, al llegar
     * a la mitad del mapa comenzara a desplazarse al lado contrario.
     */
    private int dir=-2;
    private int band=0;
    private int ran;
    private int seg;
    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        seg=mundo.dasegundos();
        move(dir);
        tambalea();
    }    

    public void mueve()
    {
        int x;
        x=getX();
        if(x<=400 && band==0)
        {
            band=1;
            setImage("normal.png");
            dir=2;
        }
        else if(band==1 && x>=600)
        {   
            setImage("perezoso.png");
            dir=-2;
        }    
    }

    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        ran=Greenfoot.getRandomNumber(600);
        int x;
        x=getX();
        mueve();
        if(seg%2==0)
            mundo.addObject(this,750,ran);

        if(isTouching(Crank.class))
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
