/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.JFrame;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Alienware
 */
public abstract class Vista extends JFrame{
    public abstract void setModelo(ListModel m);
    public abstract String[] getInformacion();
    public abstract void addAgregarActionListener(ActionListener listener);
    public abstract void setModeloTabla(TableModel m);
}
