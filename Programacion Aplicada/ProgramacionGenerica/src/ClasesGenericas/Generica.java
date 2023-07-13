/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesGenericas;

/**
 *
 * @author LENOVO
 */
public class Generica <T, U>{
    public T datoPersona;
    public U datoAlumno;

    public Generica() {
        datoPersona = null;
        datoAlumno = null;
    }

    public T getDatoPersona() {
        return datoPersona;
    }

    public void setDatoPersona(T valor) {
        datoPersona = valor;
    }

    public U getDatoAlumno() {
        return datoAlumno;
    }

    public void setDatoAlumno(U valor) {
        datoAlumno = valor;
    }
    
}
