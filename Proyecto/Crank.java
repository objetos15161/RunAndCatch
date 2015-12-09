import greenfoot.*;

/**
 * Clase del jugador, la cual tiene las mejoras, puntos, y vidas, aparte la animación del mismo
 * 
 * @oscarvelarde
 * @1 
 */
public class Crank extends Actor
{
    private int mejora=0;
    private int mejora1=1;
    private int vel=1;
    private int x;
    private int band;
    private int y;
    private int seg=0;

    private int activ=0;

    private int ini;

    private Counter vidas;
    private Counter puntos;

    private GreenfootImage actual;

    private GreenfootImage p1;
    private GreenfootImage p11;

    private GreenfootImage p2;
    private GreenfootImage p22;

    private GreenfootImage p3;
    private GreenfootImage p33;

    private GreenfootSound garra;
    private GreenfootSound vida;

    private IndBot ibot;
    private int bbot=0;
    private IndGar igar;
    private int bgar=0;
    private IndVida ivid;

    private int numvidas=5;
    private int numpuntos=0;

    /**
     * Crea los contadores de vida y puntos, tambien variables para las imagenes de la animación y sonidos que se reproducen al tocar una mejora
     */
    public Crank()
    {
        RunWorld mundo = (RunWorld)getWorld();
        vidas=new Counter("Vidas: ");
        vidas.setValue(numvidas);
        puntos=new Counter("Puntos: ");
        puntos.setValue(numpuntos);

        ibot = new IndBot();
        igar = new IndGar();
        ivid = new IndVida();

        p1=new GreenfootImage("p1.png");
        p11=new GreenfootImage("p11.png");

        p2=new GreenfootImage("p2.png");
        p22=new GreenfootImage("p22.png");

        p3=new GreenfootImage("p3.png");
        p33=new GreenfootImage("p33.png");

        setImage(p1);

        garra=new GreenfootSound("garra.mp3");
        vida = new GreenfootSound("vida.mp3");
    }

    /**
     * Agrega el contador de vidas y puntos al mundo
     */
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(vidas,70,20);
        mundo.addObject(puntos,270,20);
        mundo.addObject(ivid,145,22);
    }

    /**
     * Se encarga de verificar si toca una vida para sumarlas, desactivar la garra en caso de tocar un hamster perezoso o ardiente y quitarle la ralentizacion
     */
    public void act() 
    {
        CheckKeys();
        if(vel==0)
        {
            desactiva();
            setImage(p11);
            while(Greenfoot.getRandomNumber(10000)<=200)
            {
                vel=mejora1;
                setImage(p1);
            }
        }
        if(isTouching(Vida.class))
        {
            vida.play();
            removeTouching(Vida.class);
            sumavidas();
        }
    }    

    /**
     * Se encarga de verificar el movimiento que quiere hacer el jugador
     */
    public void CheckKeys()
    {
        x=getX();
        y=getY();
        if (Greenfoot.isKeyDown("Down"))
        {
            if(y<450)
                setLocation(x,y+vel);
        }
        else if (Greenfoot.isKeyDown("Up"))
        {
            if(y>120)
                setLocation(x,y-vel);
        }
        else if(Greenfoot.isKeyDown("d"))
        {

            if(band==1)
            {
                garra.play();
                activa();
                band=0;
            }
            else
            {   
                garra.stop();
                desactiva();
                band=1;
            }
        }

    }

    /**
     * Coloca la garra en posicion activada, pero antes verifica si tiene la mejora de la garra o no
     */
    public void activa()
    {
        if(mejora==1)
        { 
            setLocation(255,y);
            setImage(p3);
            activ=1;
        }
        else if(mejora==0)
        {   
            setLocation(218,y);
            setImage(p2);
            activ=1;
        }
    }

    /**
     * Coloca la garra en posicion DESactivada, pero antes verifica si tiene la mejora de la garra o no
     */
    public void desactiva()
    {
        if(mejora==1)
        { 
            setLocation(200,y);
            setImage(p1);
            activ=0;
        }
        else if(mejora==0)
        {   
            setLocation(200,y);
            setImage(p1);
            activ=0;
        }
    }

    /**
     * Detiene por completo al personaje
     */
    public void ralentiza()
    {
        vel=0;
    }

    /**
     * Aumenta al contador de puntos 
     */
    public void aumentapuntos(int pun)
    {
        numpuntos=numpuntos+pun;
        puntos.setValue(numpuntos);
    }

    /**
     * En caso de perder un hamster, o tocar una bala, esta funcion se llama para perder una vida
     */
    public void restavidas()
    {
        RunWorld mundo = (RunWorld)getWorld();
        numvidas=vidas.getValue();
        numvidas=numvidas-1;
        vidas.setValue(numvidas);
    }

    /**
     * En caso de tocar el objeto de la clase vida, aumenta esta en 1
     */
    public void sumavidas()
    {
        RunWorld mundo = (RunWorld)getWorld();
        numvidas=vidas.getValue();
        numvidas=numvidas+1;
        vidas.setValue(numvidas);
    }

    /**
     * Regresa la cantidad actual de vidas
     */
    public int davidas()
    {
        return numvidas;
    }

    /**
     * Regresa la cantidad actual de puntos
     */
    public int dapuntos()
    {
        return numpuntos;
    }

    /**
     * Regresa la velocidad actual
     */
    public int davel()
    {
        return vel;
    }

    /**
     * Regresa la variable que indica si tiene la mejora de la garra
    */
    public int dagarra()
    {
        return mejora;  
    }

    /**
     * Funcion que se llama al tocar la mejora de la garra, esto, aumeta el tamaño de la misma
     */
    public void masgarra()
    {
        RunWorld mundo = (RunWorld)getWorld();
        if(bbot==1)
        {
            ibot.remueve();
            bbot=0;
        }
        mundo.addObject(igar,400,30);
        bgar=1;
        mejora=1;
    }

    /**
     * Funcion que se llama al tocar la mejora de la Velocidad, esto duplica la velodicad
     */
    public void masvel()
    {
        RunWorld mundo = (RunWorld)getWorld();
        if(bgar==1)
        {
            igar.remueve();
            bgar=0;
        }
        mundo.addObject(ibot,400,30);
        bbot=1;
        vel=2;
        mejora1=2;
    }
    
    /**
     * Retira la mejora de la garra
     */
    public void menosgarra()
    {
        mejora=0;
    }
    
    /**
     * Retira la mejora de la velocidad
     */
    public void menosvel()
    {
        vel=1;
        mejora1=1;
    }

}