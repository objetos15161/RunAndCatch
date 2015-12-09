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
public class Bota extends Items
{

    private int x;
    /**
     * Al aparecer se mueve de derecha a izquierda.
     */
    public void act() 
    {
        mover();
        mejora();
    }    

    /**
     * Recibe al crank para hacerle la mejora si es necesario
     * Al tocar al Crank otorga la mejora de mas velocidad
     * pero da menos garra al crank ya que solo
     * 1 de las 2 mejoras puede estar activada a la vez.
     */
    public void mejora()
    {
        RunWorld mundo = (RunWorld)getWorld();
        Crank c = mundo.dimeCrank();  
        x=getX();
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
