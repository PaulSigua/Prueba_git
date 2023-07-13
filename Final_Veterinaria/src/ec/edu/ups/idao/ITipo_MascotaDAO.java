/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Tipo_Mascota;
import java.util.List;

/**
 *
 * @author guama
 */
public interface ITipo_MascotaDAO {
    //Métodos CRUD
    public void create(Tipo_Mascota tipo_Mascota);
    public Tipo_Mascota read(int id);
    public void update(Tipo_Mascota tipo_Mascota);
    public void delete(Tipo_Mascota tipo_Mascota); 
    
    public List<Tipo_Mascota> findAll();
}
