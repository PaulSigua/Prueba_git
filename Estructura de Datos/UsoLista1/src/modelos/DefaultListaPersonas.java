/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import javax.swing.AbstractListModel;
import java.util.ArrayList;

/**
 *
 * @author Alienware
 */
public class DefaultListaPersonas extends AbstractListModel<Persona>{
    private ArrayList<Persona> listaPersonas;

    public DefaultListaPersonas() {
        listaPersonas = new ArrayList<>();
    }  

    @Override
    public int getSize() {
        return listaPersonas.size();
    }

    @Override
    public Persona getElementAt(int index) {
        return listaPersonas.get(index);
    }
    
    public void addElement(Persona persona) {
        listaPersonas.add(persona);
        int index = listaPersonas.size();
        fireIntervalAdded(this, index, index);
    }
}
