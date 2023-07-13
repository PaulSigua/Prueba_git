/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TuentiWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerOpenTuenti implements ActionListener{
    TuentiWindow tw;

    public ListenerOpenTuenti(TuentiWindow tw) {
        this.tw = tw;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        tw.setVisible(true);
    }
    
}
