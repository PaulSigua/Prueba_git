
package logica;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Logica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        int a;
        int b;
        int c;
        System.out.print("Digite a: ");
        a = entrada.nextInt();
        
        System.out.print("Digite b: ");
        b = entrada.nextInt();
        
        System.out.print("Digite c: ");
        c = entrada.nextInt();
        
        int operacion = (a+b/c)/(a/b+c);
        //int operacion = a+(b/(a+b+b/c))/a+(b/c+a);
        
        System.out.println("Resultado: " + operacion); //Shift + Ctrl + arriba | abajo
        
        
    }
    
}
