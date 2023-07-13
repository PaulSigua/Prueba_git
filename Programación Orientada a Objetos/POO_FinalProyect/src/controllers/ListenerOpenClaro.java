/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ClaroWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerOpenClaro implements ActionListener{
    ClaroWindow cw;

    public ListenerOpenClaro(ClaroWindow cw) {
        this.cw = cw;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        cw.setVisible(true);
    }
    
}
