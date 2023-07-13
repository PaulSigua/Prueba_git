
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Cajero;


public class ControladorCajero {
    List<Cajero>listaCajero;
    
    public ControladorCajero(){
        listaCajero=new ArrayList<>();
    }
    
    public long generarId(){
        if(!listaCajero.isEmpty()){
            return listaCajero.get(listaCajero.size()-1).getId()+1;
            
        }
        return 1;
    }
    
    public boolean crearCajero(Cajero nombre){
        return listaCajero.add(nombre);
    }
    
    public int listar(){
        for(Cajero cajero:listaCajero){
            System.out.println(cajero);
        }
        return 1;
    }
    
    public Cajero buscarCajero(long Id){
        for(Cajero cajero:listaCajero){
            if(cajero.getId()==Id){
                return cajero;
            }
        }
        return null;
    }
    
    public String nombreCajero(){
        String nombre="Cajero "+generarId();
        
        return nombre;
    }
    
    public int horaFijo(){
        int horaFijo=1;
        int total=1;
        for(Cajero cajero:listaCajero){
            if(cajero.getId()==horaFijo){
                horaFijo++;
                int salida=cajero.getHoraSalida().getHour();
                int llegada=cajero.getHoraLLegada().getHour();
                total=salida-llegada;
                cajero.setHoraFijo(total);
            }
        }
        return total;
    }
    
     
    
    

}
