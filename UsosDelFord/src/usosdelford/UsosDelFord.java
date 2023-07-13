/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package usosdelford;

import java.util.ArrayList;
import java.util.List;
import usosdelford.controller.*;

/**
 *
 * @author mateo
 */
public class UsosDelFord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Stream / Lambda

        List<String> cities = new ArrayList<>();
        cities.add("Cuenca");
        cities.add("Quito");
        cities.add("Guayaquil");
        cities.add("Loja");
        cities.add("Azogues");
        cities.add("El Oro");

        for (int i = 0; i < cities.size(); i++) {
            System.out.println(cities.get(i));
        }

        System.out.println("--------------------------------------");

        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("///////////////////////////////////////");

        cities.stream().forEach(city -> System.out.println(city));

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        
        // More simple
        //cities.forEach(city -> System.out.println(city));
        
        //Simple example of Parallel - Pipeline
        //cities.stream().parallel().forEach(city -> System.out.println(city));
        
        cities.stream().filter(city -> city.startsWith("C")).forEach(city -> System.out.println(city));
    
        WindowFormulary windowFormulary = new WindowFormulary();
        ListenerSaveButton listenerSave = new ListenerSaveButton(windowFormulary);
        windowFormulary.actionListenerOk(listenerSave);
        
        ListenerDeleteButton listenerDeleteButton = new ListenerDeleteButton(windowFormulary);
        windowFormulary.actionListenerDelete(listenerDeleteButton);
        
        windowFormulary.setVisible(true);
    }

}
