import greenfoot.*;

/**
 * Imagen para scroll
 * 
 * @oscarvelarde
 * @1 
 */
public class Arbol2 extends Scroll
{   
    private int niv;
    
    /**
     * Al aparecer se mueve de derecha a izquierda
     */
    public void act() 
    {
        move(-3);
        verifica();
    }    

    /**
     * Se encarga de validar en que nivel se encuentra y hace el cambio del tipo de arbol 
     */
    public void verifica()
    {
        RunWorld mundo = (RunWorld)getWorld();
        niv=mundo.danivel();
        if(getX()<10)
            mundo.removeObject(this);
        if(niv==1)
        {
            setImage("arbol2.png"); 
        }
        else if(niv==2)
        {
            setImage("arbolhielo2.png");
        }
        else if(niv==3)
        {
            setImage("arboldes2.png");
        }    
        else if(niv==4)
        {
            setImage("arbolllamas2.png");
        }
        else if(niv==5)
        {
            setImage("vacio2.png");
        }
    }
}
