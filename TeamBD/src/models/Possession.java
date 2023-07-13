
package models;

/**
 *
 * @author mateo
 */
public class Possession {
    private int id;
    private String namePossession;

    public Possession() {
        this.id = 0;
        this.namePossession = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePossession() {
        return namePossession;
    }

    public void setNamePossession(String namePossession) {
        this.namePossession = namePossession;
    }

    @Override
    public String toString() {
        return namePossession;
    }
    
}
