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

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
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
        if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == jugar)
            {
                Greenfoot.delay(30);
                Greenfoot.setWorld(new RunWorld());
            }

        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==ayuda){
                Greenfoot.delay(5);
                Greenfoot.setWorld(new RunAyuda());
            }
        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==rec){
                Greenfoot.delay(5);
                Greenfoot.setWorld(new RunRecord());
            }
        }
        
        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==cred){
                Greenfoot.delay(5);
                Greenfoot.setWorld(new RunCredito());
            }
        }
    }
}
