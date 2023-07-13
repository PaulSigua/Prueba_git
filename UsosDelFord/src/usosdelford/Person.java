
package usosdelford;

/**
 *
 * @author mateo
 */
public class Person {
    private String name;
    private int id;
    private String age;
    private String address;

    public Person() {
        this.name = "";
        this.id = 0;
        this.age = "";
        this.address = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Identificación: " + id + ", Edad: " + age + ", Dirección: " + address;
    }
    
}
