/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelos.DefaultListaPersonas;
import modelos.DefaultTablaPersona;
import vista.Vista;

/**
 *
 * @author Alienware
 */
public class Controlador {
    DefaultListaPersonas modeloLista;
    Vista v;

    public Controlador(DefaultListaPersonas modeloLista, Vista v) {
        this.modeloLista = modeloLista;
        this.v = v;
        
        ListenerAgregar la = new ListenerAgregar(modeloLista, v);
        v.addAgregarActionListener(la);
        v.setModelo(modeloLista);
        
        DefaultTablaPersona modeloTabla = new DefaultTablaPersona(modeloLista);
        v.setModeloTabla(modeloTabla);
        
        v.setVisible(true);
    }   
}
