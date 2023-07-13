/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class DialogWindow extends JDialog implements ActionListener{
    private JLabel message;
    private JButton okButton;
    
    //Método para crear una ventana de dialogo
    public DialogWindow(Frame frame, boolean bln) {
        super(frame, bln);
        setLayout(new BorderLayout());
        message = new JLabel("Dialogo");
        okButton = new JButton("Aceptar");
        okButton.addActionListener(this);
        add(message, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);
        setSize(300,200);
    }
    
    public void showDialog(String message){
        this.message.setText(message);
        setVisible(true);
    }
    
    //Método sobreescrito
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
}
