import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.UserInfo; 

/**
 * Esta clase, se encarga de ordenar los records, es decir las puntuaciones de los jugadores.
 * 
 * @author (Angélica María Infante Barbosa) 
 import greenfoot.*;
import greenfoot.UserInfo; 
/**
 * Clase que ordena records
 * 
 * @angelicainfante
 * @?
 */
public class OrdRecords  
{
    // instance variables - replace the example below with your own
    private UserInfo player;
    public OrdRecords() 
    { 
        if (((UserInfo.getMyInfo() != null) && UserInfo.isStorageAvailable())) {
          this.player = UserInfo.getMyInfo();
        }
    }
    /**
     * Método que define la manera en que se guardarán los records
     */
    public void almacenaRecords(int pts)
    {
         if((UserInfo.isStorageAvailable()) && (this.player != null) && ((pts> this.player.getScore())) || (this.player.getInt(0))==0)
         { 
            this.player.setScore(pts);
            this.player.setInt(0,1); 
            this.player.store();
         }
        
         if((UserInfo.isStorageAvailable()) && (pts > this.player.getScore()) && (this.player != null) )
         {
            this.player.setScore(pts);
            this.player.setInt(0,1); 
            this.player.store();
         }
    }
}

