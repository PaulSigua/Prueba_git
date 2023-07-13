
package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import modelo.Cliente;


public class ControladorCliente {
    List<Cliente>listaCliente;
    Queue<Cliente>colaCliente;
    Random random;
    
    //Constructor
    public ControladorCliente(){
        listaCliente=new ArrayList<>();
        colaCliente=new LinkedList();
        random=new Random();
    }
    
    public long generarId(){
        if(!listaCliente.isEmpty()){
            return listaCliente.get(listaCliente.size()-1).getId()+1;
            
        }
        return 1;
    }
    
    public boolean crear(Cliente cliente){
      return colaCliente.offer(cliente);
    }
    
    public boolean crearLista(Cliente cliente){
      return listaCliente.add(cliente);
    }
    
    public Cliente buscarCliente(String nombre){
        for(Cliente cliente:listaCliente){
            if(cliente.getNombre().equals(nombre)){
                return cliente;
            }
        }
        return null;
    }
    
    public Cliente listar(){
        for(Cliente cliente:listaCliente){
            System.out.println(cliente);
        }
        return null;
    }
    
    public boolean eliminar(Cliente cliente){
        return listaCliente.remove(cliente);
    }
    
    public void ordenarTiempoEspera(){
        listaCliente = listaCliente.stream().sorted(Comparator.comparing
        (Cliente::getTiempoEspera)).collect(Collectors.toList());
        listar();
    }
    
    public void ordenarClienteApellido(){
        Collections.sort(listaCliente);
        listar();
    }
    
    public int tiempoEspera(){
        int num=0;
        for(int i=1;i<=10;i++){
            num=random.nextInt(10);
        }
        return num;
    }
    
    public String estadoCliente(){
        String estado="Atender";
        return estado;
    }
    
    public void atenderCliente(){
        Cliente cliente=colaCliente.poll();
        Cliente clienteLista=cliente;
        
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                Menu de atencion al cliente\n\n");
        System.out.println("\nEntra a ser atendido el cliente: "+cliente.getApellido()+"\n");
        System.out.println("El cliente "+cliente.getNombre()+" "
                    +cliente.getApellido()+" entra a ser atendido.");
        System.out.println("La duracion de tiempo de atencion fue de -> "
                    +cliente.getTiempoEspera()+" minutos.");
        System.out.println("\n!! La atencion del cliente "+cliente.getNombre()+" "
                    +cliente.getApellido()+" a terminado con exito !!");
        System.out.println("-----------------------------------------------------------------------");
        clienteLista.setEstado("Atendido");
          
    }
    
    public String comprobanteEntrada(Cliente cliente){
                System.out.println("\n▓▓▓▓▓▓▓  Comprobante Entrada  ▓▓▓▓▓▓\n▓");
                System.out.println("▓ Id del cliente : "+cliente.getId());
                System.out.println("▓ Cliente: "+cliente.getNombre()+" "+cliente.getApellido());
                System.out.println("▓ Su tiempo de atencion sera dentro de : "+cliente.getTiempoEspera()+" minutos");
                System.out.println("-Esta informacion debe ser emitada para el cliente.");
        return null;
    }
    
    public Cliente tiempoAtencionCliente(Cliente cliente){
        System.out.println("Cliente "+cliente.getNombre()+" "+cliente.getApellido()+"\n");
        System.out.println("Su tiempo de atencion sera dentro de ->"
                +cliente.getTiempoEspera()+" minutos.");
        return null;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public Queue<Cliente> getColaCliente() {
        return colaCliente;
    }

    public void setColaCliente(Queue<Cliente> colaCliente) {
        this.colaCliente = colaCliente;
    }
    
    
        
}
