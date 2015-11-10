import greenfoot.*;

/**
 * Write a description of class Reloj here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reloj extends Actor
{
    /**
     * Act - do whatever the Reloj wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private SimpleTimer timer;
    private Counter valor;
    public Reloj()
    {
        valor = new Counter("Tiempo: ");
        timer = new SimpleTimer();
    }

    protected void addedToWorld(World mundo)
    {
        mundo.addObject(valor,400,50);
    }

    public void act() 
    {
        // Add your action code here.
        if(timer.millisElapsed()>1000)
        {
            valor.add(1);
            timer.mark();
        }
    }
}
