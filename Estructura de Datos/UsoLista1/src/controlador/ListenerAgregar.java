/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vista.Vista;
import modelos.DefaultListaPersonas;
import modelos.Persona;

/**
 *
 * @author Alienware
 */
public class ListenerAgregar implements ActionListener{
    DefaultListaPersonas modeloLista;
    Vista v;

    public ListenerAgregar(DefaultListaPersonas modeloLista, Vista v) {
        this.modeloLista = modeloLista;
        this.v = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        String[] informacion = v.getInformacion();
        modeloLista.addElement(new Persona(informacion[0],informacion[1],informacion[2]));
        
    }
    
}
