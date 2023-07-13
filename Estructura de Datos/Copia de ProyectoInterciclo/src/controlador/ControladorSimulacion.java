
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.Figura;


public class ControladorSimulacion {
    private List<Figura>listaFigura;
    private Figura cliente;
    int tiempo=500;
    Random random;
    
    //Constructor
    public ControladorSimulacion(){
        listaFigura = new ArrayList<>();
        random = new Random();
    }
    
    public void crearCliente(){
        
        cliente = new Figura(400, 420, 30, 30);
        listaFigura.add(cliente);
    }
    
    public void actualizarPosicionY(){
        //Mover cliente (arriba-abajo)
        for(int i=0;i<listaFigura.size();i++){
            Figura cliFigura = listaFigura.get(i);
            cliFigura.setY(cliFigura.getY() - 20);
            listaFigura.set(i, cliFigura);
        }
    }
    
    public void actualizarPosicionX(){
        //Mover cliente (izquierda-derecha)
        for(int j=0;j<listaFigura.size();j++){
            Figura cliFigura1 = listaFigura.get(j);
            cliFigura1.setX(cliFigura1.getX()-20);
            listaFigura.set(j, cliFigura1);
        }
    }
    
    //Getter y Setters
    public List<Figura> getListaFigura() {
        return listaFigura;
    }

    public void setListaFigura(List<Figura> listaFigura) {
        this.listaFigura = listaFigura;
    }

    public Figura getCliente() {
        return cliente;
    }

    public void setCliente(Figura cliente) {
        this.cliente = cliente;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }       
}
