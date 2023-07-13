package hiloSincronizado;

/**
 *
 * @author LENOVO
 */
public class Cajero {

    VentanaCliente v;
    //private Atender atender;
    private boolean estado;
    Asignar asignar;

    public Cajero(VentanaCliente v, Asignar asignar) {
        this.v = v;
        this.estado = false;
        this.asignar = asignar;
    }


    public synchronized void atender(Atender atender, int tiempoCajero) throws InterruptedException {
        //estado = atender.getEstado();
        
        if (estado == true ) {
            System.out.println("++++++++++++++++++++++");
            System.out.println("Hilo generar clientes en pausa");
            if(estado == true && asignar.getCont() == 0){
                v.getjLabel25().setText("Espera");
            } else if(estado == true && asignar.getCont() == 1){
                v.getjLabel39().setText("Espera");
            } else if(estado == true && asignar.getCont() == 2){
                v.getjLabel49().setText("Espera");
            }
            wait();
        } 
        
        System.out.println("Se esta ejecutando el cajero" + this.getClass());
        estado = true;
        atender = new Atender(this, v, tiempoCajero, false);
        atender.start();
    }
    
    public synchronized void notificarTodos(){
        System.out.println("SE NOTIFICO A TODOS");
        System.out.println("Estado: "+estado);
        notifyAll();
    }
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
