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
    private SimpleTimer timer;
    private Counter valor;
    /**
     * La variable valor se introducira en el contador timer.
     */
    public Reloj()
    {
        valor = new Counter("Tiempo: ");
        timer = new SimpleTimer();
    }

    /**
     * Agrega el contador del reloj al mundo
     */
    protected void addedToWorld(World mundo)
    {
        mundo.addObject(valor,650,20);
    }

    /**
     * Marca cada que pasa un segundo y aumenta el valor del contador
     */
    public void act() 
    {
        if(timer.millisElapsed()>1000)
        {
            valor.add(1);
            timer.mark();
        }
    }
}
