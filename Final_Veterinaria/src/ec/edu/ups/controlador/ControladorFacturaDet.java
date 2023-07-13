/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.Factura_DetDAO;
import ec.edu.ups.idao.IFactura_DetDAO;
import ec.edu.ups.modelo.Factura_Detalle;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorFacturaDet {
    private IFactura_DetDAO factura_DetDAO;

    public ControladorFacturaDet() {
        this.factura_DetDAO=new Factura_DetDAO();
    }
    
    public void registrarDetalles(List<Factura_Detalle> detalles){
        this.factura_DetDAO.create(detalles);
        
    }
    
    public List<Factura_Detalle> buscarFactura(int id){
        List<Factura_Detalle> detalles=this.factura_DetDAO.buscarFactura(id);
        if(!detalles.isEmpty()){
            return detalles;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null;
        }
    }
    
}
