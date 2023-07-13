
package logicaTwo;

/**
 *
 * @author mateo
 */
public class CuboEspecial extends Cubo{
    
    private int clave;

    public CuboEspecial() {
        this.clave = 0;
        
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public void tipo(){
        System.out.println("Soy el cubo especial");
    }
    
}
