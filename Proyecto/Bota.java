import greenfoot.*;

/**
 * Objeto que mejora las caracteristicas del Crank.
 * 
 * Regresa al actor, que es el personaje del mundo, que haga una mejora en su velocidad
 * (Ver clase Crank)
 * 
 * @oscarvelarde
 * @1 
 */
public class Bota extends Actor
{
    /**
     * Al aparecer se mueve de derecha a izquierda.
     * Recibe al crank para hacerle la mejora si es necesario.
     */
    private int x;
    public void act() 
    {
        move(-2);
        mejora();
    }    

    public void mejora()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();  
        x=getX();
        //Desactiva la mejora de la garra en caso de que esté activada
        if(isTouching(Crank.class))
        {
            c.menosgarra();
            c.masvel();
            mundo.removeObject(this);
        }
        if(x<=100)
            mundo.removeObject(this);
    }
}
