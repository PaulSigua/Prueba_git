package model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import view.*;

/**
 *
 * @author mateo
 */
public class DefaultListClient extends AbstractListModel<Info> {

    private ArrayList<Info> listClient;
    private RechargeInformation rechargeInfo = new RechargeInformation();
    private WindowLineONE windowOne = new WindowLineONE(rechargeInfo);

    public DefaultListClient() {
        this.listClient = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listClient.size();
    }

    @Override
    public Info getElementAt(int index) {
        return listClient.get(index);
    }
    

    public void addElement(Info info) {
        listClient.add(info);
        int index = listClient.size();
        fireIntervalAdded(this, index, index);
    }

}
