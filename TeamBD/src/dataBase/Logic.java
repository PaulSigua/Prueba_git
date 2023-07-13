
package dataBase;

import views.*;
/**
 *
 * @author mateo
 */
public class Logic {
    
    private PlayersDaoImpl playersDaoImpl = new PlayersDaoImpl();
    
    public boolean addPlayersLogic(int idPlayer, String name, String password, int age, String possession){
        return playersDaoImpl.addPlayerDaoImpl(idPlayer, name, password, age, possession);
    }
}
