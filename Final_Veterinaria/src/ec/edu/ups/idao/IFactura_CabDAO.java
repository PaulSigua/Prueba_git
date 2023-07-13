/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Factura_Cabecera;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IFactura_CabDAO {
    
    public void create(Factura_Cabecera factura_Cabecera);
    public Factura_Cabecera read(int id);
    public void update(Factura_Cabecera factura_Cabecera);
    public void delete(Factura_Cabecera factura_Cabecera); 
    
    public List<Factura_Cabecera> findAll();
    
    public void anularFactura(Factura_Cabecera factura_Cabecera);
    
    public List<Factura_Cabecera> buscarPorCliente(String cedula);
    
    public List<Factura_Cabecera> buscarPorFecha(Calendar fecha);
    
    public int numeroDeFactura();
    
    
}
