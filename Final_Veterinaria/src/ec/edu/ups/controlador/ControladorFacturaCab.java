/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.Factura_CabDAO;
import ec.edu.ups.idao.IFactura_CabDAO;
import ec.edu.ups.modelo.Factura_Cabecera;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorFacturaCab {
    IFactura_CabDAO factura_CabDAO;

    public ControladorFacturaCab() {
        this.factura_CabDAO=new Factura_CabDAO();
    }
    
    public void crearFactura(Factura_Cabecera fCab){
        this.factura_CabDAO.create(fCab);
    }
    
    public void anularFacura(Factura_Cabecera fCab){
        this.factura_CabDAO.anularFactura(fCab);
    }
        
    public Factura_Cabecera buscarFactura(int id){
        Factura_Cabecera factura=this.factura_CabDAO.read(id);
        if(factura!=null){
            return factura;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null;
        }
    }
    
    public List<Factura_Cabecera> buscarFaturaPorCliente(String cedula){
        List<Factura_Cabecera> facturas=this.factura_CabDAO.buscarPorCliente(cedula);
        if(!facturas.isEmpty()){
            return facturas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null;
        }
    }
    
    public List<Factura_Cabecera> buscarFaturaPorFecha (Calendar fecha){
        List<Factura_Cabecera> facturas=this.factura_CabDAO.buscarPorFecha(fecha);
        if(!facturas.isEmpty()){
            return facturas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
            return null;
        }
    }
    
    public int numeroFactura(){
        return this.factura_CabDAO.numeroDeFactura();
    }
    
    public List<Factura_Cabecera> listarFacturas(){
        return this.factura_CabDAO.findAll();
    }
}
