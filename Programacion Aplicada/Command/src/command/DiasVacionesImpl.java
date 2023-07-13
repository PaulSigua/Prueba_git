/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author Jeiso
 */
public class DiasVacionesImpl implements IOperacion{
    private Persona persona;
    private int mesesTrabajados;
    private int diasVacaciones;

    public DiasVacionesImpl(Persona persona,int mesesTrabajdos) {
        this.persona = persona;
        this.mesesTrabajados=mesesTrabajados;
        this.diasVacaciones = 10;
    }
    
    @Override
    public void operacion() {
        this.persona.mesesVacaciones(this.mesesTrabajados);
    }

    public void setMesesTrabajados(int mesesTrabajados) {
        this.mesesTrabajados = mesesTrabajados;
    }
    
}
