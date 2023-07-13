/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anthony Moya
 */
public class Files {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        File f = new File("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Files\\src\\files\\File"); //File para crear un nuevo archivo de tipo file con el directorio
        FileWriter x; //FileWriter para poder escribir en un archivo txt, le pasamos el objeto File creado 
        try {//Abrimos bloque try donde de ejecutara el codigo esperando que no salga error
            x = new FileWriter(f); //Creamos el FileWriter
            BufferedWriter br = new BufferedWriter(x); //Le pasamos el FileWriter s un BufferedReader para optimizar la escritura
            PrintWriter pr = new PrintWriter(br); //PrintWriter para poder escribir en el archivo            
            System.out.println("Ingrese el dato numero: ");
            String datos = " ";
            datos = entrada.nextLine();
            //entrada.nextLine(pr.print(datos));
            pr.print(datos);
            //pr.print("Hola mundo"); //Escribimos dentro del archivo, es decir dentro del objeto PrintWriter
            //pr.println("\nEl archivo guardo datos exitosamente");
            pr.close(); //Indicamos que la accion de escritura ternima

            ArrayList<Integer> num = new ArrayList<>(); //Creacion de un arrayList
            for (int j = 0; j < num.get(10); j++) {
                pr.println(num);
            }

            //num.add(10); //Anidamos el array un numero
            //num.get(2); //Anidamos al array otro numero
            //pr.print(num);
        } catch (IndexOutOfBoundsException | IOException ex) {//Probamos la excepcion, como existen dos 
            //posibilidades de error (en el array y en el archivo) usamos las excepciones correspondientes
            System.out.println(ex.getMessage() + " ");
        }
    }
}
