import greenfoot.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GifImage fin;
    public GameOver()
    {
        fin=new GifImage("gameover.gif");        
    }
    public void act() 
    {
        setImage(fin.getCurrentImage());
    }    
}
