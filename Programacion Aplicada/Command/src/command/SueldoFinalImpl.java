/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author Jeiso
 */
public class SueldoFinalImpl implements IOperacion{

    private Persona persona;
    private int mesesTrabajados;
    
    public SueldoFinalImpl(Persona persona,int mesesTrabajdos){
        this.persona=persona;
        this.mesesTrabajados=mesesTrabajdos;
    }

    public void setMesesTrabajados(int mesesTrabajados) {
        this.mesesTrabajados = mesesTrabajados;
    }
    @Override
    public void operacion() {
        this.persona.sueldoFinal(this.mesesTrabajados);
    }
    
}
