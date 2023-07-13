
package logicaTwo;

/**
 *
 * @author mateo
 */
public class Cubo {
    private String nombre;
    private int textura;
    private int dimension;

    public Cubo() {
        this.nombre = "Original";
        this.textura = 0;
        this.dimension = 0;
    }

    public String getNombre() {
        System.out.println(nombre);
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void tipo(){
        System.out.println("Soy el cubo original");
    }
}
