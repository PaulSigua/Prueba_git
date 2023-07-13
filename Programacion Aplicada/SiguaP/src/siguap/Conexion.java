/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siguap;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.annotation.processing.FilerException;

/**
 *
 * @author LENOVO
 */
public class Conexion {
    private String usuario;
    private String conex;
    private static String mensaje;
    public static Scanner scan;
    public static PrintStream save;
    private static Conexion instancia; //crear instancia
    
    private Conexion(String usuario, String conex)
    {
        this.conex = conex;
        this.usuario = usuario;
        System.out.println ("Se crea el acceso con el usuario: " + usuario);
    }
    
    public static Scanner archivo() throws FileNotFoundException{
        String fichero = "fichero.txt";
        scan = new Scanner(new File(mensaje));
        scan.reset();
        return scan;
        
    }
    
    public static Conexion obtenerInstancia(String usuario, String conex) throws FileNotFoundException
    {
        if(instancia==null)
        {
            instancia = new Conexion(usuario, conex);
        }
        else if(instancia != null){
            System.out.println ("No se puede crear la conexion con "+usuario);
        }
        else if(!instancia.equals(usuario)){
            System.out.println("Se crea " + conex + " con el usuario: " + usuario);
        }
        return instancia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getConex() {
        return conex;
    }

    public static Conexion getInstancia() {
        return instancia;
    }
    
    public void leerArchivo(){
        if(scan==null){
            System.out.println("El archivo fue leido" + scan);
        }
        else{
            scan.findInLine("No se pudo leer el archivo. Ocurrio un error");
        }
    }
    public void escribirArchivo(){
        save.print(mensaje);
        System.out.println("Esta es una prueba");
    }
    
    //Arreglo de objectos para poder escribir al poder mandar solo una instancia
    
    
    
    //Leer las dos conexiones.
    //Que el fichero guarde la informacion
    //FileRead
}
