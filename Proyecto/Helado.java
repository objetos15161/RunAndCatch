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
    /**
     * Act - do whatever the Helado wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound rompe;
    private int seg;
    private int ran;
    private int vel=-2;
    private int band=0;
    public Helado()
    {
        rompe=new GreenfootSound("rompe.wav");
    }

    public void act() 
    {
        RunWorld mundo = (RunWorld)getWorld();
        verifica();
        seg=mundo.dasegundos();
        tambalea();
        move(vel);
    }    

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
