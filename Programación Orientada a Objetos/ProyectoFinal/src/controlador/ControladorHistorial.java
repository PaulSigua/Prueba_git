/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import modelo.Cliente;
import modelo.Historial;
import modelo.Ventanilla;

/**
 *
 * @author LENOVO
 */
public class ControladorHistorial {
    private List<Ventanilla> ventanillaList;
    
    public ControladorHistorial()
    {
        ventanillaList = new ArrayList<>();     
        for (int i = 0; i<3; i++)
        {            
            ventanillaList.add(new  Ventanilla(i));
        }
    } 
    

    
    public void agregar(int ventanilla, int tiempo, Cliente cliente)
    {
        Historial hisotrial = new Historial(tiempo, cliente);      
        ventanillaList.get(ventanilla).addHistorial(hisotrial);
    }
    
    public Ventanilla getHistoryById(int id)
    {
        return ventanillaList.get(id);
    }
    
  
    public List<Historial> orderByTiempo(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getTiempo));      
        return aux.get(ventanilla).getHitorialList();
    }
    
    public List<Historial> orderByNombre(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getNombre));      
        return aux.get(ventanilla).getHitorialList();
    }
    
    public List<Historial> orderByApellido(int ventanilla)
    {
        List<Ventanilla> aux = ventanillaList;
        aux.get(ventanilla).getHitorialList().sort(Comparator.comparing(Historial::getApellido));      
        return aux.get(ventanilla).getHitorialList(); 
    }
    public void orderByAtendidos()
    {   
        List<Ventanilla> aux = ventanillaList;
        aux.sort(Comparator.comparing(Ventanilla::getSize).reversed());      
        
        for(Ventanilla v : aux)
        {
            System.out.println(v.getAtenciones());
        }
    }

    public List<Ventanilla> getVentanillaList() {
        return ventanillaList;
    }
}
