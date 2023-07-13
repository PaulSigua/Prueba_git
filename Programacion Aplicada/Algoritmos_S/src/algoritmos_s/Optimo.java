/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmos_s;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Usuario
 */
public class Optimo {

    private Vector referencias;
    private int numMarcos;
    private Vector marcos;
    private int fallos;
    private ArrayList pos;
    private String[][] registro;
    private int cont2;

    public Optimo(Vector referencias, int numMarcos) {
        this.referencias = referencias;
        this.numMarcos = numMarcos;
        marcos = new Vector(numMarcos);
        fallos = 0;
        cont2 = 0;
        for (int i = 0; i < numMarcos; i++)//Colocar todos lo valores como nulos
        {
            marcos.addElement(" ");
        }
        registro = new String[numMarcos][0];

    }

    public void ejecutar() {
        System.out.println("ALGORIMO OPTIMO");
        System.out.println(referencias);
        System.out.println("Marcos: " + numMarcos + "\n");
        for (int i = 0; i < referencias.size(); i++) {
            for (int j = 0; j < numMarcos; j++) {
                if (marcos.get(j) == referencias.get(i))//La pagina si esta cargada
                {
                    break;
                } else if (marcos.get(j) == " ")//El marco esta vacio
                {
                    marcos.set(j, referencias.get(i));
                    registrar();
                    fallos++;
                    break;
                } else if (i == referencias.size() - 1 && j == numMarcos - 1)//Si el la ultima referencia remplazo en el primer marco
                {
                    System.out.println("Si entrooooo");
                    marcos.set(0, referencias.get(i));
                    registrar();
                    fallos++;
                    break;
                } else if ((j + 1) == numMarcos)//La pagina no esta cargada
                {
                    pos = new ArrayList();
                    pos.clear();
                    boolean llave = false;
                    int mayor;
                    for (int k = 0; k < numMarcos; k++)//Buscar la posicion del ultimo numero de cada uno
                    {
                        for (int l = i; l < referencias.size(); l++)//Buscar el primer numero hacia la derecha 
                        {
                            if (marcos.get(k) == referencias.get(l))//Se encontro el numero y se guarda la posicion 
                            {
                                pos.add(l);
                                break;
                            } else if (l == referencias.size() - 1)//la referencia del marco ya no se repite mas
                            {
                                fallos++;
                                marcos.set(k, referencias.get(i));
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
                        mayor = Integer.parseInt(pos.get(0) + "");
                        for (int k = 1; k < pos.size(); k++)//Buscar cual es el ultimo numero
                        {
                            if (Integer.parseInt(pos.get(k) + "") > mayor) {
                                mayor = Integer.parseInt(pos.get(k) + "");
                            }
                        }
                        for (int k = 0; k < marcos.size(); k++)//Remplazar el marco con el numero mas lejano
                        {
                            if (Integer.parseInt(marcos.get(k) + "") == Integer.parseInt(referencias.get(mayor) + "")) {
                                marcos.set(k, referencias.get(i));
                                break;
                            }
                        }
                        fallos++;
                    }
                    registrar();
                    break;
                }
            }
        }
        imprimir();
    }

    public void registrar()//Los marcos son registrados
    {
        int columnas = registro[0].length + 1;
        String[][] registroAux = registro.clone();//Se crea un copia del registro
        registro = new String[numMarcos][columnas];
        if (registroAux[0].length != 0)//Validar que la copia del registro no este vacio
        {
            for (int i = 0; i < numMarcos; i++) {
                for (int j = 0; j < registroAux[0].length; j++) {
                    registro[i][j] = registroAux[i][j];//Guardar la lista de registro antigua en la nueva que tiene una columna extra
                }
            }
        }
        for (int j = cont2; j < columnas; j++)//Hacer el registro del ultimo marco modificado
        {
            for (int i = 0; i < numMarcos; i++) {
                registro[i][j] = marcos.get(i) + "";
            }
        }
        cont2++;
    }

    public void imprimir() {
        int columnas = registro[0].length;
        for (int i = 0; i < numMarcos; i++)//Imprimir el regristro de los marcos
        {
            for (int j = 0; j < columnas; j++) {
                System.out.print(registro[i][j] + "    ");
            }
            System.out.println("");
        }
        System.out.println("\n" + "Fallos de pagina: " + fallos + "\n");
    }
}
