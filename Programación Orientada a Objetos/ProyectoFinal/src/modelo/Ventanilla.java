/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Ventanilla {
    private List<Historial> hitorialList;
    private int ventanilla;

    public Ventanilla(List<Historial> hitorialList) { 
        this.hitorialList = new ArrayList<>();
        this.hitorialList = hitorialList;
        
    }
    public Ventanilla(int ventanilla)
    {
        this.ventanilla = ventanilla;
        this.hitorialList = new ArrayList<>();
    }

    public List<Historial> getHitorialList() {
        return hitorialList;
    }

    public void setHitorialList(List<Historial> hitorialList) {
        this.hitorialList = hitorialList;
    }

    public int getVentanilla() {
        return ventanilla;
    }

    public void setVentanilla(int ventanilla) {
        this.ventanilla = ventanilla;
    }

 
    @Override
    public String toString() {
        String result;
        result = "Ventanilla " + this.ventanilla;
        for (Historial h : hitorialList)
        {
            result += "Tiempo de atención: " + h.getTiempo() + " minutos " + h.getCliente();
        }
        return result;
    }
    
    public String getAtenciones()
    {
        return "Ventanilla " + this.ventanilla + "\n " + "Clientes atendidos: " + this.getSize();
        
        
        
    }
    public void addHistorial(Historial historial)
    {
        hitorialList.add(historial);
    }
    
    public int getSize()
    {
       return hitorialList.size();
    }
}
