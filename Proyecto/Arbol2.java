import greenfoot.*;

/**
 * Write a description of class Arbol2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol2 extends Scroll
{
    /**
     * Act - do whatever the Arbol2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int niv;
    public void act() 
    {
        move(-3);
        verifica();
    }    
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
            setImage("arbolllamas2.png");
        }
        else if(niv==4)
        {
            setImage("vacio2.png");
        }
    }
}
