
package dataBase;

/**
 *
 * @author mateo
 */
public class Controller {
    Logic logic = new Logic();
    
    public boolean addlogic(int idPlayer, String name, String password, int age, String possession){
        return logic.addPlayersLogic(idPlayer, name, password, age, possession);
    }

    public Controller() {
        
    }
    
}
