/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Factura_Detalle;
import java.util.List;

/**
 *
 * @author guama
 */
public interface IFactura_DetDAO {
    
    public void create(List<Factura_Detalle> detalles);
    public Factura_Detalle read(int id);
    public void update(Factura_Detalle factura_Detalle);
    public void delete(Factura_Detalle factura_Detalle); 
    
    public List<Factura_Detalle> buscarFactura(int id);
}
