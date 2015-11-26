import greenfoot.*;

/**
 * Gif 800x553 para a pantalla de juego terminado.
 * 
 * @oscarvelarde
 * @1 
 */
public class GameOver extends Actor
{
    /**
     * El constructor toma la imagen de la carpeta "images" del proyecto.
     * El act muestra la secuencia del gif.
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
