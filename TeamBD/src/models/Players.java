package models;

/**
 *
 * @author mateo
 */
public class Players {

    private String userName;
    private String password;
    private int age;
    private String possession;

    public Players(String userName, String password, int age, String possession) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.possession = possession;
    }

    @Override
    public String toString() {
        return "Players{" + "userName=" + userName + ", password=" + password + ", age=" + age + ", possession=" + possession + '}';
    }
    
}
