/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepciones1;

/**
 *
 * @author Jeison
 */
public class Excepciones1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*double num, den, res;
        Scanner entrada = new Scanner(System.in);
        try {
            System.out.print("Ingrese numerador: ");
            num = entrada.nextDouble();
            System.out.print("Ingrese denominador: ");
            den = entrada.nextDouble();
            res = num / den;
        } 
        catch (InputMismatchException ex) {
            ex.printStackTrace();
            System.out.println("Se debe ingresar un numero...");
            res = NaN;
        } 
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            res = NaN;
        } 
        finally {
            System.out.print("El resultado de la division es: ");
        }
        System.out.println(res);*/
        Calculo c = new Calculo();
        try{
            /*c.setOp1(4);
            /*c.setOp2(5);*/
            System.out.println(c.calcular());
        }
        catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
    }

}
