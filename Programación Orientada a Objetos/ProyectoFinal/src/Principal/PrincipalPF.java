/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import vista.VistaBanco;
import vista.VistaCliente;

/**
 *
 * @author LENOVO
 */
public class PrincipalPF {
    public static void main(String [] args){
        VistaBanco banco = new VistaBanco();
        banco.setVisible(true);
        VistaCliente vistaCliente = new VistaCliente();
        vistaCliente.menu();
    }
}
