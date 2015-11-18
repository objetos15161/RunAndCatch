import greenfoot.*;

/**
 * Write a description of class Arbol3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol3 extends Scroll
{
    /**
     * Act - do whatever the Arbol3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int niv;
    private int x;
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
            setImage("arbol3.png"); 
        }
        else if(niv==2)
        {
            setImage("arbolhielo3.png");
        }
        else if(niv==3)
        {
            setImage("arbolllamas3.png");
        }
        else if(niv==4)
        {
            setImage("vacio3.png");
        }
    }
}
