
package Algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author LENOVO
 */
public class AlgoritmoSSTF {

    private List<Integer> referencias;
    private List<Integer> copiaReferencias;
    private List<Integer> copia2;
    private ArrayList desplazamientos;
    private int totalDesplazameintos;
    private int referencia;

    public AlgoritmoSSTF(List<Integer> referencias) {
        this.referencias = referencias;
        copiaReferencias = referencias;
        desplazamientos = new ArrayList();
        totalDesplazameintos = 0;
        copia2 = new ArrayList();
    }

    public void operar() {
        System.out.println("LOGARITMO SSTF");
        System.out.println("Refefrencias: "+referencias);
        int referencia = referencias.get(0);
        referencias = referencias.stream().sorted().collect(Collectors.toList());
        int posReferencia = 0;
        int referenciaCerca = 0;
        int cantRef = referencias.size();

        for (int i = 0; i < cantRef; i++) {
            for (int j = 0; j < referencias.size()-1; j++)//Buscar la posicion de la referencia
            {
                if (referencias.get(j) == referencia) {
                    posReferencia = j;
                    break;
                }
            }
            int desplaA;
            int desplaB;
            if (posReferencia == referencias.size() - 1) {
                desplaA = 999999;
            } else {
                desplaA = Math.abs(referencia - referencias.get(posReferencia + 1));
            }

            if (posReferencia == 0) {
                desplaB = 999999;
            } else {
                desplaB = Math.abs(referencia - referencias.get(posReferencia - 1));
            }

            int referenciaA = referencia;
            if (desplaA < desplaB)//Buscar cual desplazamiento esta mas cerca
            {
                referencia = referencias.get(posReferencia + 1);
                referenciaCerca = desplaA;
            } else {
                if (referencias.size() == 1) {
                    break;
                }
                referencia = referencias.get(posReferencia - 1);
                referenciaCerca = desplaB;
            }
            desplazamientos.add(referenciaCerca);
            List<Integer> copia = new ArrayList();
            for (int k = 0; k < referencias.size(); k++)//Reducir las referencias que estan vacias
            {
                if (referenciaA == referencias.get(k)) {
                    copia2.add(referenciaA);
                } else {
                    copia.add(referencias.get(k));
                }
            }
            referencias = new ArrayList();
            referencias = copia;
        }
        for (int j = 0; j < desplazamientos.size(); j++)//Calcular total de desplazamientos
        {
            int numA = Integer.parseInt(desplazamientos.get(j) + "");
            totalDesplazameintos = numA + totalDesplazameintos;
        }
        imprimir();

    }

    public void imprimir() {
        for (int i = 0; i < desplazamientos.size(); i++) {
            if (i == desplazamientos.size() - 1) {
                break;
            } else {
                System.out.println(copia2.get(i) + "  " + desplazamientos.get(i));
            }
        }
        System.out.println("Desplazamientos: " + totalDesplazameintos);
        System.out.println("");
    }
}
