/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MoviWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerOpenMovi implements ActionListener{
    MoviWindow mw;

    public ListenerOpenMovi(MoviWindow mw) {
        this.mw = mw;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        mw.setVisible(true);
    }
}
