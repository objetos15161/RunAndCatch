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
    private int niv;

    private int valor=0;

    private SimpleTimer reloj;

    private Counter cadReloj;

    private Hamster hamster;
    private Helado helado;
    private Perezoso perezoso;
    private Ardiente ardiente;
    private Rocoso rocoso;
    private ArenaScroll arena;
    
    private Lobo1 lobo1;
    private Lobo2 lobo2;
    private Lobo3 lobo3;
    private Lobo4 lobo4;

    private Nivel1 niv1;
    private Nivel2 niv2;
    private Nivel3 niv3;
    private Nivel4 niv4;
    
    private Arbol1 a1;
    private Arbol2 a2;
    private Arbol3 a3;
    
    private GreenfootSound s1;
    private GreenfootSound s2;
    private GreenfootSound s3;
    private GreenfootSound s4;

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

        
    }

    public void prepararObjetos()
    {
        crank = new Crank(5,0);

        hamster = new Hamster();
        helado = new Helado();
        perezoso = new Perezoso();
        ardiente = new Ardiente();
        rocoso = new Rocoso();
        reloj = new SimpleTimer();
        niv=1;
        cadReloj = new Counter("Tiempo:  ");
        cadReloj.setValue(0);//valor inicial de 60 segundos
        segundos=0;
        arena = new ArenaScroll();
        
        s1=new GreenfootSound("nivel1.mp3");
        s2=new GreenfootSound("nivel2.mp3");
        s3=new GreenfootSound("nivel3.mp3");
        s4=new GreenfootSound("nivel4.mp3");
        
        niv1=new Nivel1();
        niv2=new Nivel2();
        niv3=new Nivel3();
        niv4=new Nivel4();
        
        nivel=new Counter("Nivel: ");

    }

    public void act()
    {
        if((segundos==0 && niv==1) || (segundos==60 && niv==2) || (segundos==120 && niv==3) || (segundos==180 && niv==4))
                presenta();
        cambiaNivel();
        addObject(cadReloj,400,50);
        scroll();
        if(reloj.millisElapsed()>=1000)
        {
            reloj.mark();
            cadReloj.add(1);
            segundos++;
        }
    }

    public void scroll()
    {
        if ( Greenfoot.getRandomNumber(1000) < 5)
            creaArbol1();
        if ( Greenfoot.getRandomNumber(1000) < 5)
            creaArbol2();
        if ( Greenfoot.getRandomNumber(1000) < 3)
            creaArbol3();    
    }

    public void cambiaNivel()
    {    
        if(segundos<=59)
        {
            niv=1;
            nivel.setValue(1);      
            nivel1();
        }
        
                
        else if((segundos>=60)&&(segundos<=119))
        {
            niv=2;
            nivel.setValue(2);
            nivel2();
        }
        else if((segundos>=120)&&(segundos<=179))
        {
            niv=3;
            nivel.setValue(3);
            nivel3();
        }
        else if((segundos>=180)&&(segundos<=240))
        {
            niv=4;
            nivel.setValue(4);
            nivel4();
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

        else if(segundos==59)
        {
            removeObject(hamster);
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
        setBackground("fondo3.jpg");
        if(band==1)
        {
            if(helado.verifica()==1)
                removeObject(helado);
            band=0;
        }
        else if(segundos==119)
        {
            removeObject(helado);
        }
        else
        {
            addObject(helado,750,n);
            band=1;
        }
    }

    public void nivel3()
    {
        n=Greenfoot.getRandomNumber(500); 
        setBackground("fondo2.jpg");
        if(band==1)
        {
            if(ardiente.verifica()==1)
                removeObject(ardiente);
            band=0;
        }
        else if(segundos==179)
        {
            removeObject(ardiente);
        }
        else
        {
            addObject(ardiente,750,n);
            band=1;
        }
    }

    public void nivel4()
    {
        n=Greenfoot.getRandomNumber(500); 
        setBackground("fondo4.jpg");
        if(band==1)
        {
            if(rocoso.verifica()==1)
                removeObject(rocoso);
            band=0;
        }
        else if(segundos==239)
        {
            removeObject(rocoso);
        }
        else
        {
            addObject(rocoso,750,n);
            band=1;
        }
    }

    private void creaArbol1()
    {
        Arbol1 a1= new Arbol1();
        addObject(a1,800,540);
    }

    private void creaArbol2()
    {
        Arbol2 a2= new Arbol2();
        addObject(a2,800,560);
    }

    private void creaArbol3()
    {
        Arbol3 a3= new Arbol3();
        addObject(a3,800,550);
    }

    public int dasegundos()
    {
        return(segundos);
    }

    public int danivel()
    {
        return(niv);
    }

    public void presenta()
    {
        int indi;
        if(niv==1)
        {
            addObject(niv1,400,300);
            s1.play();
            Greenfoot.delay(100);
            removeObject(niv1);
            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            indi=0;
        }
        else if(niv==2)
        {
            s1.stop();
            s2.play();
            addObject(niv2,400,300);
            Greenfoot.delay(100);
            removeObject(niv2);
            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            indi=0;
        }
        else if(niv==3)
        { 
            s2.stop();
            s3.play();
            addObject(niv3,400,300);
            Greenfoot.delay(100);
            removeObject(niv3);
            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            indi=0;
        }
        else if(niv==4)
        {
            s3.stop();
            s4.playLoop();
            addObject(niv4,400,300);
            Greenfoot.delay(100);
            removeObject(niv4);
            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            indi=0;
        }
        

    }
    public void crealobo(int x, int y,int indi)
    {
        if(indi==1)
        {
        if(niv==1)
        {
            lobo1 = new Lobo1();
            addObject(lobo1,x,y);
        }
        else if(niv==2)
        {
            lobo2 = new Lobo2();
            addObject(lobo2,x,y);
        }
        else if(niv==3)
        {
            lobo3 = new Lobo3();
            addObject(lobo3,x,y);
        }
        else if(niv==4)
        {
            lobo4 = new Lobo4();
            addObject(lobo4,x,y);
        }
    }

}
}










