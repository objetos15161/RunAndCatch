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
    /**
     * La funcion verifica realiza la ralentizacion al Crank si es tocado
     */
    private int r=0;
    private GreenfootSound ral;
    public Rocoso()
    {
        ral = new GreenfootSound("tocallamas.wav");
        while(r==0)
        {
            r=Greenfoot.getRandomNumber(3);
        }
    }
    public void act() 
    {
        verifica();
        move(-(r));
        tambalea();
    }    
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();   
        int x;
        x=getX();
        if(isTouching(Crank.class))
        {    
            c.ralentiza();
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
    public void quema()
    {
        ral.play();
    }
}
