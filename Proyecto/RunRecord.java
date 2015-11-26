import greenfoot.*;

/**
 * Mundo que muestra las mejores puntuaciones obtenidas en este juego
 * 
 * @oscarvelarde
 * @1
 */
public class RunRecord extends World
{
    private Salir salir;
    private GreenfootSound fondo;
    private ScoreBoard score;
    /**
     * Constructor de la pantalla de records
     * 
     */
    public RunRecord()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        score=new ScoreBoard(600, 400);
        fondo=new GreenfootSound("record.mp3");
        salir=new Salir();
        colocar();

    }

    // Coloca el boton de salida y la pantalla de records
    public void colocar()
    {
        addObject(salir,750,50);
        addObject(score,400,300);
    }

    public void act()
    {
        fondo.play();
        if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                Greenfoot.delay(30);
                fondo.stop();
                Greenfoot.setWorld(new Menu());
            }

        }
    }
}
