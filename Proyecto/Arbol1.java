import greenfoot.*;

/**
 * Write a description of class Arbol1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol1 extends Scroll
{
    /**
     * Act - do whatever the Arbol1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int niv;
    public void act() 
    {
        move(-2);
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
            setImage("arbol1.png");
            
        }
        else if(niv==2)
        {
            setImage("arbolhielo1.png");
        }
        else if(niv==3)
        {
            setImage("arboldes1.png");
        }    
        else if(niv==4)
        {
            setImage("arbolllamas1.png");
        }
        else if(niv==5)
        {
            setImage("vacio1.png");
        }
    }
}
