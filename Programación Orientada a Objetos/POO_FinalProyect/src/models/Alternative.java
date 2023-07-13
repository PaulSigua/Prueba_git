/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractListModel;

/**
 *
 * @author LENOVO
 */
public class Alternative extends AbstractListModel{
    ArrayList alternative;

    public Alternative(HashMap alternative) {
        this.alternative = new ArrayList(alternative.values());
    }

    @Override
    public int getSize() {
        return alternative.size();
    }

    @Override
    public Object getElementAt(int a) {
        return alternative.get(a);
    }
    
}
