package controlador;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import modelo.Nodo;

public class ControladorVehiculo {

    private LinkedList<Nodo> listaVehiculo;
    private Nodo raiz;

    public ControladorVehiculo() {
        listaVehiculo = new LinkedList<>();
        raiz = null;
    }

    public boolean crear(Nodo nodo) {
        return listaVehiculo.add(nodo);
    }

    public void ordenarAsc() {
        Collections.sort(listaVehiculo, new Comparator<Nodo>(){
            @Override
            public int compare(Nodo o1, Nodo o2) {
                return o1.getPlaca().compareTo(o2.getPlaca());
            }
            
        });
    }

    public void ordenDes() {
        Collections.sort(listaVehiculo, new Comparator<Nodo>(){
            @Override
            public int compare(Nodo o1, Nodo o2) {
                return o1.getHora().compareTo(o2.getHora());
            }
            
        });
    }

    public int busquedaBinaria(String hora) {
        int bajo = 0;
        int alto = listaVehiculo.size() - 1;
        int posicion = -1;
        while (bajo <= alto) {
            int centro = (bajo + alto) / 2;
            if (listaVehiculo.get(centro).getHora().equals(hora)) {
                posicion = centro;
                break;
            } else if (listaVehiculo.get(centro).getHora().compareTo(hora) < 0) {
                alto = centro;
            } else if (listaVehiculo.get(centro).getHora().compareTo(hora) > 0) {
                bajo = centro + 1;
            }
        }
        return posicion;
    }

    public int busquedaSecuencial(String placa) {
        for (int i = 0; i < listaVehiculo.size(); i++) {
            Nodo nodo = listaVehiculo.get(i);
            if (nodo.getPlaca().equalsIgnoreCase(placa)) {
                return i;
            }
        }
        return -1;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo llamar(int pos) {
        return listaVehiculo.get(pos);
    }

    public LinkedList<Nodo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(LinkedList<Nodo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public List<Nodo> listar() {
        return listaVehiculo;
    }

    public Integer getMarks() {
        return null;
    }
}
