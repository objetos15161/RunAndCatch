import greenfoot.*;

/**
 * Write a description of class RunWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunWorld extends World
{
    private int band;
    private int n=50;
    private int a=0;

    private int valor=0;
    private SimpleTimer reloj;

    private Counter cadReloj;

    private Hamster hamster;
    private Helado helado;
    private Perezoso perezoso;
    private Ardiente ardiente;
    private ArenaScroll arena;

    private Crank crank;
    private Counter nivel;
    private int segundos=0;
    /**
     * Constructor for objects of class RunWorld.
     * 
     */
    public RunWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepararObjetos();
        addObject(crank,200,400);
        addObject(nivel,750,20);
        addObject(cadReloj,500,30);
    }

    public void prepararObjetos()
    {
        crank = new Crank();

        hamster = new Hamster();
        helado = new Helado();
        perezoso = new Perezoso();
        ardiente = new Ardiente();

        reloj = new SimpleTimer();

        cadReloj=new Counter("Tiempo:  ");
        cadReloj.setValue(0);//valor inicial de 60 segundos

        arena=new ArenaScroll();

        nivel=new Counter("Nivel: ");

    }
    public void act()
    {
        cambiaNivel();
        addObject(cadReloj,400,50);
        arena();
    }

    public void arena()
    {
        int i;
        if(a==0)
        {
            addObject(arena,800,Greenfoot.getRandomNumber(500));
            a=1;
        }
        else
        {
            if(arena.verifica()==1)
            {
                removeObject(arena);
            }
            a=0;
        }
    }

    public void cambiaNivel()
    {    
        if(reloj.millisElapsed()>=1000)
        {
            reloj.mark();
            cadReloj.add(1);
            segundos++;
            /* else 
             * {
             *     nivel2();
             *  }           */
        }
        if(segundos<=59)
        {
                nivel.setValue(1);
                nivel1();
                
        }
        else if(segundos>=60)
        {
                removeObject(hamster);
                nivel.setValue(2);
                nivel2();
        }
        
    }

    public void nivel1()
    {
        n=Greenfoot.getRandomNumber(500); 
        if(band==1)
        {
            if(hamster.verifica()==1)
                removeObject(hamster);
            band=0;
        }
        else
        {
            addObject(hamster,750,n);
            band=1;
        }
    }

    public void nivel2()
    {
        n=Greenfoot.getRandomNumber(500); 
        setBackground("fondo2.jpg");
        if(band==1)
        {
            if(helado.verifica()==1)
                removeObject(helado);
            band=0;
        }
        else
        {
            addObject(helado,750,n);
            band=1;
        }
    }
}
