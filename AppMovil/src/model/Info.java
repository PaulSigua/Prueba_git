
package model;

/**
 *
 * @author mateo
 */
public class Info {
    private String name;
    private String id;
    private String cell;
    private String age;
    private String nameLine;

    public Info(String name, String id, String cell, String age, String nameLine) {
        this.name = name;
        this.id = id;
        this.cell = cell;
        this.age = age;
        this.nameLine = nameLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }
    
}
