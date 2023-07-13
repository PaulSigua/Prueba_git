package algoritmos;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class AlgoritmoOptimo {

    private Vector valorReferencia;
    private int numMarcos;
    private Vector marcos;
    private int fallos;
    private ArrayList posicion;
    private String[][] registro;
    private int cont2;

    public AlgoritmoOptimo(Vector valorReferencia, int numMarcos) {
        this.valorReferencia = valorReferencia;
        this.numMarcos = numMarcos;
        marcos = new Vector(numMarcos);
        fallos = 0;
        cont2 = 0;
        for (int i = 0; i < numMarcos; i++){
            marcos.addElement(" ");
        }
        registro = new String[numMarcos][0];

    }

    public void ejecutarOptimo() {
        System.out.println("-------------------------------------------------");
        System.out.println("ALGORIMO ÓPTIMO");
        System.out.println("Referencias: " + valorReferencia);
        System.out.println("Marcos: " + numMarcos + "\n");
        for (int i = 0; i < valorReferencia.size(); i++) {
            for (int j = 0; j < numMarcos; j++) {
                if (marcos.get(j) == valorReferencia.get(i)){
                    break;
                } else if (marcos.get(j) == " "){
                    marcos.set(j, valorReferencia.get(i));
                    registrarOPT();
                    fallos++;
                    break;
                } else if (i == valorReferencia.size() - 1 && j == numMarcos - 1){ //Si la ultima referencia ya fue reemplazada
                    marcos.set(0, valorReferencia.get(i));
                    registrarOPT();
                    fallos++;
                    break;
                } else if ((j + 1) == numMarcos){ //Pregunta si la pagina no esta cargada
                    posicion = new ArrayList();
                    posicion.clear();
                    boolean llave = false;
                    int mayor;
                    for (int k = 0; k < numMarcos; k++){//Busca la posicion del ultimo numero de cada marco
                        for (int l = i; l < valorReferencia.size(); l++){//Busca el primer numero hacia la derecha
                            if (marcos.get(k) == valorReferencia.get(l)){ //Pregunta si lo encuentra al numero y lo guarda
                                posicion.add(l);
                                break;
                            } else if (l == valorReferencia.size() - 1){ //Si el valor del marco ya no se repite
                                fallos++;
                                marcos.set(k, valorReferencia.get(i));
                                llave = true;//Cierro la llave
                                break;
                            }
                        }
                        if (llave == true)//Se rompe el buqle porque ya se remplazo la referencia en el marco
                        {
                            break;
                        }
                    }
                    if (llave == false)//Si no se remplazo nada entra al bucle 
                    {
                        mayor = Integer.parseInt(posicion.get(0) + "");
                        for (int k = 1; k < posicion.size(); k++)//Buscar cual es el ultimo numero
                        {
                            if (Integer.parseInt(posicion.get(k) + "") > mayor) {
                                mayor = Integer.parseInt(posicion.get(k) + "");
                            }
                        }
                        for (int k = 0; k < marcos.size(); k++){ //Reemplaza el marco con el valor mas lejano que se encuentre
                            if (Integer.parseInt(marcos.get(k) + "") == Integer.parseInt(valorReferencia.get(mayor) + "")) {
                                marcos.set(k, valorReferencia.get(i));
                                break;
                            }
                        }
                        fallos++;
                    }
                    registrarOPT();
                    break;
                }
            }
        }
        imprimir();
    }

    public void registrarOPT(){
        int columnas = registro[0].length + 1;
        String[][] registroAux = registro.clone();//Crea un copia del registro
        registro = new String[numMarcos][columnas];
        if (registroAux[0].length != 0)//Pregunta si que la copia del registro no esta vacio
        {
            for (int i = 0; i < numMarcos; i++) {
                for (int j = 0; j < registroAux[0].length; j++) {
                    registro[i][j] = registroAux[i][j];//Guardar la lista del registro antiguo en la nueva que tiene una columna extra (clone)
                }
            }
        }
        for (int j = cont2; j < columnas; j++){ //Busca el ultimo marco existente
            for (int i = 0; i < numMarcos; i++) {
                registro[i][j] = marcos.get(i) + "";
            }
        }
        cont2++;
    }

    public void imprimir() {
        try{
        int columnas = registro[0].length;
        for (int i = 0; i < numMarcos; i++)
        {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + registro[i][j] + "|   ");
            }
            System.out.println("");
        }
        System.out.println("\n" + "Fallos: " + fallos + "\n");
        } catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("No debe ingresar un valor igual a 0");
        }
    }
}
