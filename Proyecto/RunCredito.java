import greenfoot.*;

/**
 * Mundo que muestra la pantalla con los creditos, coloca un boton de salida y reproduce una
 * musica de fondo
 * 
 * @oscarvelarde
 * @1
 */
public class RunCredito extends World
{
    private Salir salir;
    private GreenfootSound credi;
    public RunCredito()
    {    
        super(800, 600, 1); 
        credi=new GreenfootSound("credito.mp3");
        salir=new Salir();
        colocar();
    }

    //Coloca el boton de salir
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
