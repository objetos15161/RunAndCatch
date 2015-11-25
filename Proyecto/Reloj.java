import greenfoot.*;

/**
 * Esta clase se encarga de mostrar y agregar en el mundo un contador
 * con los segundos transcurridos en el mundo.
 * 
 * @angelicainfante 
 * @1
 */
public class Reloj extends Actor
{
    /**
     * La variable valor se introducira en el contador timer.
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
        mundo.addObject(valor,650,20);
    }

    public void act() 
    {
        if(timer.millisElapsed()>1000)
        {
            valor.add(1);
            timer.mark();
        }
    }
}
