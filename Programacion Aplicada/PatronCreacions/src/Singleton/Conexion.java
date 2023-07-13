/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author aplaza
 */
public class Conexion 
{
    private String usuario;
    private String conex;
    private static String mensaje;
    public static Scanner text;
    public static PrintStream save;
    private static Conexion instancia; //crear instancia
    
    private Conexion(String usuario, String conex)
    {
        this.conex = conex;
        this.usuario = usuario;
        System.out.println ("Se crea el acceso con el usuario: " + usuario);
    }
    
    public static Conexion obtenerInstancia(String usuario, String conex)
    {
        if(instancia==null)
        {
            instancia=new Conexion(usuario, conex);
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
    
    public void escribirArchivo(){
        save.print(mensaje);
        System.out.println("Esta es una prueba");
    }
    
    public void leerArchivo(){
        text.hasNext();
        System.out.println("El archivo fue leido");
        text.delimiter();
        text.close();
        text.radix();
    }

    public static Conexion archivoCreado(){
        instancia.escribirArchivo();
        
        return null;
    }
    
    //Arreglo de objectos para poder escribir al poder mandar solo una instancia
    
    
    
    //Leer las dos conexiones.
    //Que el fichero guarde la informacion
    //FileRead
    
    
}
