import greenfoot.*;

/**
 * Imagen estática
 * 
 * @oscarvelarde
 * @1 
 */
public class IndGar extends Indicador
{
    /**
     * Remueve este indicador en caso de que la otra mejora la obtenga el crank
     */
    public void remueve()
    {
        RunWorld mundo = (RunWorld)getWorld();
        mundo.removeObject(this);
    }
}
