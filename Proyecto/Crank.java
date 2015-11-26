import greenfoot.*;

/**
 * Write a description of class Crank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crank extends Actor
{
    /**
     * Act - do whatever the Crank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
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
    private IndGar igar;
    private IndVida ivid;
    
    private int numvidas=5;
    private int numpuntos=0;

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

    protected void addedToWorld(World mundo)
    {
        mundo.addObject(vidas,70,20);
        mundo.addObject(puntos,270,20);
    }

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

    public void ralentiza()
    {
        vel=0;
    }

    public void aumentapuntos(int pun)
    {
        numpuntos=numpuntos+pun;
        puntos.setValue(numpuntos);
    }

    public void restavidas()
    {
        RunWorld mundo = (RunWorld)getWorld();
        numvidas=vidas.getValue();
        numvidas=numvidas-1;
        vidas.setValue(numvidas);
    }
    
    public void sumavidas()
    {
        RunWorld mundo = (RunWorld)getWorld();
        numvidas=vidas.getValue();
        numvidas=numvidas+1;
        vidas.setValue(numvidas);
    }

    public int davidas()
    {
        return numvidas;
    }
    
    public int dapuntos()
    {
        return numpuntos;
    }
    
    public int davel()
    {
        RunWorld mundo = (RunWorld)getWorld();
        mundo.addObject(ibot,400,30);
        return vel;
    }
    
    public int dagarra()
    {
        return mejora;  
    }
    
    public void masgarra()
    {
        mejora=1;
    }
    
    public void masvel()
    {
        vel=2;
        mejora1=2;
    }
    
    public void menosgarra()
    {
        mejora=0;
    }
    
    public void menosvel()
    {
        vel=1;
        mejora1=1;
    }
    
}