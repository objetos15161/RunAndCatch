import greenfoot.*;

/**
 * Clase que controla todo lo relacioado con el funcionamiento del juego
 * y todos sus niveles, se accede a esta a travez de el Menu.
 * 
 * @oscarvelarde
 * @1
 */
public class RunWorld extends World
{
    private int niv; //variable entera que cambia cada vez que se sube de nivel

    private SimpleTimer reloj; //Variable que controla el timer

    //Variables que controlan el contador del reloj y nivel
    private Counter cadReloj; 
    private Counter nivel;

    //Declaracion de los actores del juego que son los personajes que debes capturar, hay 5 tipos      
    private Hamster hamster;
    private Helado helado;
    private Perezoso perezoso;
    private Ardiente ardiente;
    private Rocoso rocoso;

    //Declaracion de los actores que son los lobos que persiguen a los hamsters
    private Lobo1 lobo1;
    private Lobo2 lobo2;
    private Lobo3 lobo3;
    private Lobo4 lobo4;
    private Lobo5 lobo5;

    //Declaracion de objetos que sirven como pantallas de cambio de nivel, y la ultima como pantalla de juego terminado
    private Nivel1 niv1;
    private Nivel2 niv2;
    private Nivel3 niv3;
    private Nivel4 niv4;
    private Nivel5 niv5;
    private GameOver gameover;

    //Declaracion de los objetos que ayudan a simular el scroll que se puede observar en la parte inferior
    private Arbol1 a1;
    private Arbol2 a2;
    private Arbol3 a3;

    //Declaracion de los sonidos de cada nivel
    private GreenfootSound s1;
    private GreenfootSound s2;
    private GreenfootSound s3;
    private GreenfootSound s4;
    private GreenfootSound s5;

    //Sonido de la pantalla del Juego Terminado
    private GreenfootSound fin;

    //Declaracion del actor que controla el jugador
    private Crank crank;

    //Declaracion e inicializacion de la variables enteras que ayudan a indicar cuantos segundos han transcurrido y en que nivel se encuentra
    private int segundos=0;
    private int p;

    //Declaracion de los objetos que dan un plus al personaje
    private Bota bota;
    private Garra garra;
    private Vida vida;
    private Bala bala;

    //Declaracion de la clase adicional que se creo para ordenar records
    private OrdRecords records;

    //Declaraciond el boton que, al perder el juego, aparecerá y debes clickear para regresar al menú
    private Salir salir;
    /**
     * Se crea la pantalla con un standar de 800x600 que es la que se adapta a  la mayoria de computadoras
     * 
     */
    public RunWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //Funcion que crea los objetos del juego
        prepararObjetos();
        //Se agrega el personaje a la pantalla del mundo
        addObject(crank,200,400);
        addObject(nivel,520,20);
    }

    public void prepararObjetos()
    {
        //Creacion de los objetos necesarios para este mundo
        crank = new Crank();
        records=new OrdRecords();
        gameover=new GameOver();
        reloj = new SimpleTimer();

        niv1=new Nivel1();
        niv2=new Nivel2();
        niv3=new Nivel3();
        niv4=new Nivel4();
        niv5=new Nivel5();

        niv=1;
        segundos=0;

        cadReloj = new Counter("Tiempo:  ");
        nivel=new Counter("Nivel: ");
        cadReloj.setValue(0);
        nivel.setValue(0);

        s1=new GreenfootSound("nivel1.mp3");
        s2=new GreenfootSound("nivel2.mp3");
        s3=new GreenfootSound("nivel3.mp3");
        s4=new GreenfootSound("nivel4.mp3");
        s5=new GreenfootSound("nivel5.mp3");
        fin=new GreenfootSound("fin.wav");

        salir = new Salir();

    }

    public void act()
    {
        //cada que se cambia de nivel se hace una presentacion de cada uno de ellos
        if((segundos==0 && niv==1) || (segundos==60 && niv==2) || (segundos==120 && niv==3) || (segundos==180 && niv==4) || (segundos==240 && niv==5))
        {
            presenta();
            //Al pasar de nivel, agrega las mejoras en el mapa
            if(niv>1)
                creamejoras();
        }
        //Crea una vida o una bala cada cierto momento
        if(Greenfoot.getRandomNumber(10000)<=3)
            creavida();
        if(Greenfoot.getRandomNumber(3000)<=2)
            creabala();
        addObject(cadReloj,720,20);
        scroll();

        //Conteo de segundos
        if(reloj.millisElapsed()>=1000)
        {
            reloj.mark();
            cadReloj.add(1);
            segundos++;
        }

        //Validacion para determinar si se perdieron toda slas vidas
        if(crank.davidas()==0)
            findejuego();
        p=crank.dapuntos();

        //Llamada a la funcion que realiza los cambios de nivel
        cambiaNivel();
    }

    public void scroll()
    {
        //Se agrega aleatoriamente 3 tipos distintos de arboles para simular el scroll        
        if ( Greenfoot.getRandomNumber(1000) < 3)
            creaArbol1();
        if ( Greenfoot.getRandomNumber(1000) < 4)
            creaArbol2();
        if ( Greenfoot.getRandomNumber(1000) < 2)
            creaArbol3();    
    }

    public void cambiaNivel()
    {   
        //Hace el cambio en el Contador del mundo y en la variable niv, esto lo hace por minuto hasta el nivel 5
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
        else if((segundos>=180)&&(segundos<=239))
        {
            niv=4;
            nivel.setValue(4);
            nivel4();
        }
        else if(segundos>=240)
        {
            niv=5;
            nivel.setValue(5);
            nivel5();
        }
    }

    public void nivel1()
    {
        //se crean hamsters normales y perezosos en sitios aleatorios y se cambia el fondo del mundo
        int ran=300;
        int ran1=300;
        setBackground("fondo1.jpg");
        while(ran>=100 && ran<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=4)
                creanormal(ran);
            ran=Greenfoot.getRandomNumber(500);
        }
        while(ran1>=100 && ran1<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=2)
                creaperezoso(ran1);
            ran1=Greenfoot.getRandomNumber(500);
        }
    }

    public void nivel2()
    {
        //se crean hamsters normales y helados en sitios aleatorios y se cambia el fondo del mundo
        int ran=300;
        int ran1=300;
        setBackground("fondo3.jpg");
        while(ran>=100 && ran<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=4)
                creanormal(ran);
            ran=Greenfoot.getRandomNumber(500);
        }
        while(ran1>=100 && ran1<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=2)
                creahielo(ran1);
            ran1=Greenfoot.getRandomNumber(500);
        }
    }

    public void nivel3()
    {
        //se crean hamsters normales y rocosos en sitios aleatorios y se cambia el fondo del mundo
        int ran=300;
        int ran1=300;
        setBackground("fondo2.jpg");
        while(ran>=100 && ran<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=4)
                creanormal(ran);
            ran=Greenfoot.getRandomNumber(500);
        }
        while(ran1>=100 && ran1<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=2)
                crearocoso(ran1);
            ran1=Greenfoot.getRandomNumber(500);
        }
    }

    public void nivel4()
    {
        //se crean hamsters normales y ardientes en sitios aleatorios y se cambia el fondo del mundo
        int ran=300;
        int ran1=300;
        setBackground("fondo4.jpg");
        while(ran>=100 && ran<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=4)
                creanormal(ran);
            ran=Greenfoot.getRandomNumber(500);
        }
        while(ran1>=100 && ran1<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=2)
                creaardiente(ran1);
            ran1=Greenfoot.getRandomNumber(500);
        }
    }

    public void nivel5()
    {
        //se crean hamsters normales y de cualquier tipo en sitios aleatorios y se cambia el fondo del mundo
        int ran=300;
        int ran1=300;
        int tipo;
        setBackground("fondo5.jpg");
        while(ran>=100 && ran<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=4)
                creanormal(ran);
            ran=Greenfoot.getRandomNumber(500);
        }
        while(ran1>=100 && ran1<=500)
        {
            if(Greenfoot.getRandomNumber(5000)<=2)
            {
                tipo=Greenfoot.getRandomNumber(4);
                if(tipo==0)
                {
                    creaardiente(ran1);
                }
                else if(tipo==1)
                {
                    crearocoso(ran1);
                }
                else if(tipo==2)
                {
                    creahielo(ran1);
                }
                else if(tipo==3)
                {
                    creaperezoso(ran1);
                }        
            }
            ran1=Greenfoot.getRandomNumber(500);
        }
    }

    //Las funciones siguientes regresan los segundos y el nivel actual, esto ayuda a algunas otras clases a definir un comportamiento distinto
    public int dasegundos()
    {
        return(segundos);
    }

    public int danivel()
    {
        return(niv);
    }

    //Esta ayuda a otras clases en caso de hacer un cambio en el jugador

    public Crank dimeCrank()
    {
        return crank;
    }

    /*La funcion presenta muestra una pantalla con el nivel que se jugará y crea los lobos que tambien cambian segun el nivel, tambien reproduce 
     * la musica que es distinta en cada nivel
     */

    public void presenta()
    {
        int indi;
        if(niv==1)
        {
            addObject(niv1,400,300);
            Greenfoot.delay(100);
            removeObject(niv1);

            s1.play();

            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            crealobo(25,300,indi);
            indi=0;
        }
        else if(niv==2)
        {
            s1.stop();

            addObject(niv2,400,300);
            Greenfoot.delay(100);
            removeObject(niv2);
            s2.play();
            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            crealobo(25,300,indi);
            indi=0;
        }
        else if(niv==3)
        { 
            s2.stop();

            addObject(niv3,400,300);
            Greenfoot.delay(100);
            removeObject(niv3);

            s3.play();

            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            crealobo(25,300,indi);
            indi=0;
        }
        else if(niv==4)
        {
            s3.stop();

            addObject(niv4,400,300);
            Greenfoot.delay(100);
            removeObject(niv4);

            s4.playLoop();

            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            crealobo(25,300,indi);
            indi=0;
        }
        else if(niv==5)
        {
            s4.stop();

            addObject(niv5,400,300);
            Greenfoot.delay(100);
            removeObject(niv5);

            s5.playLoop();

            indi=1;
            crealobo(75,150,indi);
            crealobo(45,200,indi);
            crealobo(55,250,indi);
            crealobo(25,300,indi);
            crealobo(55,350,indi);
            crealobo(45,400,indi);
            crealobo(25,300,indi);
            indi=0;
        }

    }

    //Las funciones siguientes crean objetos cada vez que sean llamados, esto ayuda a no crear muchas variables para objetos del mismo tipo

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

    public void creanormal(int num)
    {
        hamster = new Hamster();
        addObject(hamster,750,num);
    }

    public void creahielo(int num)
    {
        helado = new Helado();
        addObject(helado,750,num);
    }

    public void crearocoso(int num)
    {
        rocoso = new Rocoso();
        addObject(rocoso,750,num);
    }

    public void creaperezoso(int num)
    {
        perezoso = new Perezoso();
        addObject(perezoso,750,num);
    }

    public void creaardiente(int num)
    {
        ardiente = new Ardiente();
        addObject(ardiente,750,num);
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
            else if(niv==5)
            {
                lobo5 = new Lobo5();
                addObject(lobo5,x,y);
            }
        }

    }

    public void creavida()
    {
        int x;
        x=Greenfoot.getRandomNumber(350);
        vida = new Vida();
        addObject(vida,750,x+120);
    }

    public void creabala()
    {
        int x;
        x=Greenfoot.getRandomNumber(350);
        bala = new Bala();
        addObject(bala,750,x+120);
    }

    public void creamejoras()
    {
        garra = new Garra();
        bota = new Bota();
        addObject(garra,750,200);
        addObject(bota,750,400);
    }

    //Esta funcion detiene todo y muestra una pantalla con un gif de Juego Terminado y un botón que te regresa al menu principal si es tocado
    public void findejuego()
    {
        s1.stop();
        s2.stop();
        s3.stop();
        s4.stop();
        s5.stop();
        removeObjects(getObjects(Actor.class));
        addObject(gameover,getWidth()/2,getHeight()/2);
        addObject(salir,400,500);
        records.almacenaRecords(p);
        fin.playLoop();
        reloj.mark();
        if(Greenfoot.getMouseInfo()!=null)
        { 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                fin.stop();
                Greenfoot.setWorld(new Menu());
            }
        }
    }
}

