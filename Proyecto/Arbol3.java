import greenfoot.*;

/**
 * Imagen para scroll
 * 
 * @oscarvelarde
 * @1 
 */
public class Arbol3 extends Scroll
{
    private int niv;
    private int x;
    
    /**
     * Al aparecer, se mueve de izquierda a derecha 
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
            setImage("arbol3.png"); 
        }
        else if(niv==2)
        {
            setImage("arbolhielo3.png");
        }
        else if(niv==3)
        {
            setImage("arboldes3.png");
        }    
        else if(niv==4)
        {
            setImage("arbolllamas3.png");
        }
        else if(niv==5)
        {
            setImage("vacio3.png");
        }
    }
}
