/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Cita;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author guama
 */
public interface ICitaDAO {
     
    public void create(Cita cita);
    public Cita read(int id);
    public void update(Cita cita);
    public void delete(Cita cita);
    
    public void cancelarCita(Cita cita);
    public void reagendarCita(int id,Calendar fecha,int per_id);
    public List<Cita> buscarPorFecha(Calendar fecha);
    public List<Cita> buscarPorVeterinario(String cedula);
    public List<Cita> buscarPorCliente(String cedula);
    
    public List<Cita> findAll();
}
