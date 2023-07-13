
package logicaTwo;

/**
 *
 * @author mateo
 */
public class LogicaBasica {
    
    public static void main(String[] args) {
        Cubo cubo = new Cubo();
        cubo.tipo();
        cubo.getNombre();
        
        System.out.println("-------------------");
        
        Cubo cEspecial = new CuboEspecial();
        CuboEspecial cuboEspecial = new CuboEspecial();
        cEspecial.tipo();
        cEspecial.setNombre("Especial 2.0");
        System.out.println("Mi nuevo nombre es: " + cEspecial.getNombre());
        cuboEspecial.setClave(0106764);
    }
}
