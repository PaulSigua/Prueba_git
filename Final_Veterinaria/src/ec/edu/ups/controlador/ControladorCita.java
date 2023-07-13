
package ec.edu.ups.controlador;

import ec.edu.ups.dao.CitaDAO;
import ec.edu.ups.idao.ICitaDAO;
import ec.edu.ups.modelo.Cita;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author guama
 */
public class ControladorCita {
    ICitaDAO citaDAO;
    
    public ControladorCita() {
        this.citaDAO = new CitaDAO();
    }
    
    public void agendarCita(Cita cita){
        this.citaDAO.create(cita);
    }
    
    public void buscarCita(int id){
        this.citaDAO.read(id);
    }
    
    public void reagendarCita(int id,Calendar fecha,int per_id){
        this.citaDAO.reagendarCita(id, fecha, per_id);
    }
    
    public void eliminarCita(Cita cita){
        this.citaDAO.delete(cita);
    }
    
    public void cancelarCita(Cita cita){
        this.citaDAO.cancelarCita(cita);
    }
    
    public List<Cita> listarCitas(){
        return this.citaDAO.findAll();
    }
    
    public List<Cita> buscarCitaPorFecha(Calendar fecha){
        List<Cita> citas=this.citaDAO.buscarPorFecha(fecha);
        if (!citas.isEmpty()) {
            
            return citas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Cita> buscarCitaPorVeterinario(String cedula){
        List<Cita> citas=this.citaDAO.buscarPorVeterinario(cedula);
        if (!citas.isEmpty()) {
            
            return citas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
    
    public List<Cita> buscarCitaPorCliente(String cedula){
        List<Cita> citas=this.citaDAO.buscarPorCliente(cedula);
        if (!citas.isEmpty()) {            
            return citas;
        }else{
            JOptionPane.showMessageDialog(null, "No se encontro Resultados");
        }
        return null;
    }
}
