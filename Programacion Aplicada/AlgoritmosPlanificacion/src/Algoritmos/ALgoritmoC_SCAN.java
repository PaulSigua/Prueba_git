
package Algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author LENOVO
 */
public class ALgoritmoC_SCAN {

    private List<Integer> referencias;
    private List<Integer> copiaReferencias;
    private ArrayList desplazamientos;
    private int totalDesplazameintos;
    private int referencia;
    private int numMin;
    private int numMax;

    public ALgoritmoC_SCAN(List<Integer> referencias, int numMin, int numMax) {
        this.referencias = referencias;
        copiaReferencias = new ArrayList();
        desplazamientos = new ArrayList();
        totalDesplazameintos = 0;
        this.numMin = numMin;
        this.numMax = numMax;
    }

    public void operar() {
        System.out.println("LOGARITMO C_SCAN");
        System.out.println("Referencias: "+referencias);
        int referencia = referencias.get(0);
        int referenciaAux = referencia;
        referencias = referencias.stream().sorted().collect(Collectors.toList());
        int posReferencia = 0;
        int posReferenciaAux = 0;
        int cantRef = referencias.size();

        for (int i = 0; i < cantRef; i++) {
            for (int j = 0; j < referencias.size(); j++)//Buscar la posicion de la referencia
            {
                if (referencias.get(j) == referencia) {
                    posReferencia = j;
                    if (i == 0) {
                        posReferenciaAux = posReferencia;
                    }
                    break;
                }
            }
            
            if (posReferencia > 0) {
                desplazamientos.add(Math.abs(referencia - referencias.get(posReferencia - 1)));
            }
            copiaReferencias.add(referencia);//guardar la referencia usada

            if (referencia == referencias.get(0))//Si esta en la primera
            {
                copiaReferencias.add(numMin);
                desplazamientos.add(Math.abs(referencia - numMin));
                desplazamientos.add(Math.abs(numMin - referencias.get(posReferenciaAux)-1));

                for (int j = referencias.get(posReferencia)-1; j < referencias.size(); j++) {
                    copiaReferencias.add(referencias.get(j));
                    referencia = referencias.get(j);
                    if (j == referencias.size() - 1) {
                        break;
                    } else {
                        desplazamientos.add(Math.abs(referencia - referencias.get(j + 1)));
                    }
                }
                copiaReferencias.add(numMax);
                desplazamientos.add(Math.abs(referencia - numMax));
                break;
            } else {
                referencia = referencias.get(posReferencia - 1);
            }

        }

        for (int j = 0; j < desplazamientos.size(); j++)//Calcular total de desplazamientos
        {
            int numA = Integer.parseInt(desplazamientos.get(j) + "");
            totalDesplazameintos = numA + totalDesplazameintos;
        }
        imprimir();
    }

    public void imprimir() {
        for (int i = 0; i < copiaReferencias.size(); i++) {
            if (i == copiaReferencias.size() - 1) {
                break;
            } else {
                System.out.println(copiaReferencias.get(i) + "  " + desplazamientos.get(i));
            }
        }
        System.out.println(copiaReferencias.get(copiaReferencias.size() - 1));
        System.out.println("Desplazamientos: " + totalDesplazameintos);
        System.out.println("");
        System.out.println("");
    }
}
