/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

/**
 *
 * @author UPS
 */
public class ControladorEmpleado {

    private List<Empleado> listaEmpleados;

    public ControladorEmpleado() {
        listaEmpleados = new ArrayList();
    }

    public boolean crear(Empleado empleado) {
        return listaEmpleados.add(empleado);
    }

    public boolean eliminar(Empleado empleado) {
        return listaEmpleados.remove(empleado);
    }

    public Empleado leer(String nombre) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado;
            }
        }
        return null;
    }

    public void listar() {
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }

    public boolean actualizar(Empleado empleado) {
        int index = listaEmpleados.indexOf(empleado);
        if (index >= 0) {
            listaEmpleados.set(index, empleado);
            return true;
        }
        return false;
    }

    public void ordenarShellBySueldo() {
        boolean cambios = false;
        for (int k = listaEmpleados.size() / 2; k != 0; k /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = k; i < listaEmpleados.size(); i++) {
                    if (listaEmpleados.get(i - k).getSueldo() > listaEmpleados.get(i).getSueldo()) {
                        Empleado aux = listaEmpleados.get(i);
                        listaEmpleados.set(i, listaEmpleados.get(i - k));
                        listaEmpleados.set(i - k, aux);
                        cambios = true;
                    }
                }
            }
        }
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
