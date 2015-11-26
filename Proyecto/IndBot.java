import greenfoot.*;

/**
 * Imagen estática
 * 
 * @oscarvelarde
 * @1 
 */
public class IndBot extends Indicador
{
    public void remueve()
    {
        RunWorld mundo = (RunWorld)getWorld();
        mundo.removeObject(this);
    }
}
