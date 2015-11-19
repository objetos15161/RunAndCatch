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
    /**
     * Constructor for objects of class RunCredito.
     * 
     */
    public RunCredito()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        salir=new Salir();
        colocar();
    }
    public void colocar()
    {
        addObject(salir,750,50);
    }
    public void act()
    {
         if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                Greenfoot.delay(30);
                Greenfoot.setWorld(new Menu());
            }

        }
    }
}
