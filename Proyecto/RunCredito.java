import greenfoot.*;

/**
 * Write a description of class RunCredito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunCredito extends World
{
    private Salir salir;
    private GreenfootSound credi;
    /**
     * Constructor for objects of class RunCredito.
     * 
     */
    public RunCredito()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        credi=new GreenfootSound("credito.mp3");
        salir=new Salir();
        colocar();
    }
    public void colocar()
    {
        addObject(salir,750,50);
    }
    public void act()
    {
        credi.play();
         if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                Greenfoot.delay(30);
                credi.stop();
                Greenfoot.setWorld(new Menu());
            }

        }
    }
}
