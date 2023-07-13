package algoritmos;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class AlgoritmoFCFS {

    private Vector valorReferencia;
    private Vector marcos;
    private String[][] registro;
    private int numMarcos;
    private int cont2;
    private int cont;
    private int fallos;

    public AlgoritmoFCFS(Vector valorReferencias, int numMarcos) {
        this.valorReferencia = valorReferencias;
        this.numMarcos = numMarcos;
        cont2 = 0;
        fallos = 0;
        marcos = new Vector(numMarcos);
        cont = 0;
        for (int i = 0; i < numMarcos; i++) {
            marcos.addElement(" ");
        }
        registro = new String[numMarcos][0];
    }

    public void ejecutarFCFS() {
        System.out.println("ALGORITMO FCFS");
        System.out.println("Referencias: " + valorReferencia);
        System.out.println("Marcos: " + numMarcos);
        for (int i = 0; i < valorReferencia.size(); i++) {
            for (int j = 0; j < numMarcos; j++) {
                if (marcos.get(j) == " ")//Pregunta si la variable marco está vacio
                {
                    marcos.set(j, valorReferencia.get(i));
                    registrarFCFS();
                    break;
                } else if (marcos.get(j) == valorReferencia.get(i))//Preguntasi la pagina si esta cargada
                {
                    break;
                } else if ((j + 1) == numMarcos)// Pregunta si la pagina no esta cargada
                {
                    if (cont == numMarcos)//Si el contador llega al final del marco está regresa al principio, se reinicia
                    {
                        cont = 0;
                    }
                    marcos.set(cont, valorReferencia.get(i));// Reemplazar en el orden que llegan
                    registrarFCFS();
                    cont++;
                    break;
                }
            }
        }
        imprimir();
    }

    public void registrarFCFS() {
        int columnas = registro[0].length + 1;
        String[][] registroAux = registro.clone();
        registro = new String[numMarcos][columnas];
        if (registroAux[0].length != 0) {
            for (int i = 0; i < numMarcos; i++) {
                for (int j = 0; j < registroAux[0].length; j++) {
                    registro[i][j] = registroAux[i][j];
                }
            }
        }
        for (int j = cont2; j < columnas; j++)//Registra los marcos
        {
            for (int i = 0; i < numMarcos; i++) {
                registro[i][j] = marcos.get(i) + "";
            }
        }
        cont2++;
        fallos++;
    }

    public void imprimir() {
        try{
        int columnas = registro[0].length;
        for (int i = 0; i < numMarcos; i++) //Imprimir el regristro 
        {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + registro[i][j] + "|  ");
            }
            System.out.println("");
        }
        System.out.println("\n" + "Fallos: " + fallos + "\n");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No debe ingresar un valor igual a 0");
        }
    }
}
