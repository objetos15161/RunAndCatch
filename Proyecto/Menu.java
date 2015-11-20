import greenfoot.*;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Jugar jugar;
    private Ayuda ayuda;
    private Record rec;
    private Credito cred;
    private GreenfootSound press;
    private GreenfootSound fondo;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        press=new GreenfootSound("boton.wav");
        fondo=new GreenfootSound("menu.mp3");
        jugar=new Jugar();
        ayuda=new Ayuda();
        rec=new Record();
        cred=new Credito();
        colocar();
    }

    public void colocar()
    {
        addObject(jugar,609,178);
        addObject(ayuda,609,278);
        addObject(rec,609,378);
        addObject(cred,609,478);

    }

    public void act()
    {
        fondo.play();
        if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == jugar)
            {
                press.play();
                Greenfoot.delay(30);
                fondo.stop();
                Greenfoot.setWorld(new RunWorld());
            }

        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==ayuda)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                Greenfoot.setWorld(new RunAyuda());
            }
        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==rec)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                Greenfoot.setWorld(new RunRecord());
            }
        }
        
        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==cred)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                Greenfoot.setWorld(new RunCredito());
            }
        }
    }
}
