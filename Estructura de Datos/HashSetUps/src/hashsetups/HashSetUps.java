/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsetups;

import vista.VistaPersona;

/**
 *
 * @author Anthony Moya
 */
public class HashSetUps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Set<String> setNoDuplicados = new HashSet<String>();
        setNoDuplicados.add("Diego");
        setNoDuplicados.add("Maria");
        setNoDuplicados.add("Juan");
        setNoDuplicados.add("Luisa");
        
        setNoDuplicados.forEach(s -> System.out.println(s));
        
        //Validar los no duplicados
        setNoDuplicados.add("maria");
        System.out.println("Validacion");
        //eliminar
        setNoDuplicados.remove("maria");
       
        
        //buscar
        System.out.println(setNoDuplicados.contains("diego"));
        
        //actualizar (No existe un metodo dirrecto)
        setNoDuplicados.remove("Diego");
        setNoDuplicados.add("Diegos");
        setNoDuplicados.forEach(s -> System.out.println(s));
        
        //size tamañó
        System.out.println(setNoDuplicados.size());
*/
        VistaPersona vistaPersona = new VistaPersona();
        vistaPersona.menu();
        
        //Implemetar un LinkedHashSet con numeros y persona
        
    }
    
}
