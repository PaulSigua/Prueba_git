/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MaxiplusWindow;

/**
 *
 * @author LENOVO
 */
public class ListenerOpenMaxi implements ActionListener{
    MaxiplusWindow mxw;

    public ListenerOpenMaxi(MaxiplusWindow mxw) {
        this.mxw = mxw;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        mxw.setVisible(true);
    }
}
