package algoritmos;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class AlgoritmoLRU {

    private ArrayList pos;
    private Vector valorReferencia;
    private Vector marcos;
    private int numMarcos;
    private int fallos;
    private int cont2;
    private String[][] registro;

    public AlgoritmoLRU(Vector valorReferencia, int numMarcos) {
        this.valorReferencia = valorReferencia;
        this.numMarcos = numMarcos;
        cont2 = 0;
        fallos = 0;
        marcos = new Vector(numMarcos);
        addElemento();
        registro = new String[numMarcos][0];
    }

    public void ejecutarLRU() {
        System.out.println("-------------------------------------------------");
        System.out.println("ALGORITMO LRU");
        System.out.println("Referencias: " + valorReferencia);
        System.out.println("Marcos: " + numMarcos + "\n");
        for (int i = 0; i < valorReferencia.size(); i++) {
            for (int j = 0; j < numMarcos; j++) {
                if (marcos.get(j) == " ") {
                    marcos.set(j, valorReferencia.get(i));
                    registrarLRU();
                    fallos++;
                    break;
                } else if (marcos.get(j) == valorReferencia.get(i)) { //Pregunta si la pagina esta cargada
                    break;
                } else if ((j + 1) == numMarcos) { //O si la pagina no lo esta
                    pos = new ArrayList();
                    pos.clear();
                    int menor;
                    for (int k = 0; k < numMarcos; k++) { //Busca la posicion del primer numero ingresado
                        for (int l = i; l >= 0; l--) {
                            if (marcos.get(k) == valorReferencia.get(l)) {
                                pos.add(l);
                                break;
                            }
                        }
                    }
                    menor = Integer.parseInt(pos.get(0) + "");
                    for (int k = 1; k < pos.size(); k++) { //Busca el primer numero ingresado
                        if (Integer.parseInt(pos.get(k) + "") < menor) {
                            menor = Integer.parseInt(pos.get(k) + "");
                        }
                    }
                    for (int k = 0; k < marcos.size(); k++) {// Reemplaza el numero mas lejano de la izquierda
                        if (Integer.parseInt(marcos.get(k) + "") == Integer.parseInt(valorReferencia.get(menor) + "")) {
                            marcos.set(k, valorReferencia.get(i));
                            break;
                        }
                    }
                    fallos++;
                    registrarLRU();
                    break;
                }
            }
        }
        imprimir();
    }

    public void registrarLRU() {
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
        for (int j = cont2; j < columnas; j++) {//registra la cantidad de 
            for (int i = 0; i < numMarcos; i++) {
                registro[i][j] = marcos.get(i) + "";
            }
        }
        cont2++;
    }

    public void imprimir() {
        try {
            int columnas = registro[0].length;
            for (int i = 0; i < numMarcos; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print("|" + registro[i][j] + "|  ");
                }
                System.out.println("");
            }
            System.out.println("\n" + "Fallos: " + fallos + "\n");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("No debe ingresar un valor igual a 0");
        }
    }

    public void addElemento() {
        for (int i = 0; i < numMarcos; i++) {
            marcos.addElement(" ");
        }
    }
}
