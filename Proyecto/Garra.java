import greenfoot.*;

/**
 * Objeto que mejora las caracteristicas del Crank.
 * 
 * Regresa al actor, que es el personaje del mundo, que haga una mejora en su garra
 * (Ver clase Crank)
 * 
 * @oscarvelarde
 * @1 
 */
public class Garra extends Actor
{
    /**
     * Al aparecer se mueve de derecha a izquierda y al tocar al Crank otorga
     * las mejoras.
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
        /*
         * Al tocar al Crank otorga la mejora de mas garra
         * pero da menos velocidad al crank ya que solo
         * 1 de las 2 mejoras puede estar activada a la vez.
         */
        if(isTouching(Crank.class))
        {
            c.masgarra();
            c.menosvel();
            mundo.removeObject(this);
        }
        // Limite, al llegar se remueve el objeto
        if(x<=100)
            mundo.removeObject(this);
    }
}
