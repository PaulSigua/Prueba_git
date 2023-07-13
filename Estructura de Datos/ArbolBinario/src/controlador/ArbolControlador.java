/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Nodo;

/**
 *
 * @author diego
 */
public class ArbolControlador {

    private Nodo raiz;

    public ArbolControlador() {
        raiz = null;
    }

    public void crear(Nodo nodo, Nodo raiz) {
        if (this.raiz == null) {
            this.raiz = nodo;
        } else {
            if (nodo.getDato() <= raiz.getDato()) {
                if (raiz.getIzq() != null) {
                    crear(nodo, raiz.getIzq());
                } else {
                    raiz.setIzq(nodo);
                }
            } else {
                if (raiz.getDer() != null) {
                    crear(nodo, raiz.getDer());
                } else {
                    raiz.setDer(nodo);
                }
            }
        }
    }

    public void inOrden(Nodo nodo) {
        if (nodo.getIzq() != null) {
            inOrden(nodo.getIzq());
        }
        System.out.println(nodo.getDato());
        if (nodo.getDer() != null) {
            inOrden(nodo.getDer());
        }
    }

    public void preOrden(Nodo nodo) {
        System.out.println(nodo.getDato());
        if (nodo.getIzq() != null) {
            preOrden(nodo.getIzq());
        }
        if (nodo.getDer() != null) {
            preOrden(nodo.getDer());
        }
    }

    public void posOrden(Nodo nodo) {
        if (nodo.getIzq() != null) {
            posOrden(nodo.getIzq());
        }
        if (nodo.getDer() != null) {
            posOrden(nodo.getDer());
        }
        System.out.println(nodo.getDato());
    }

    public Nodo buscar(Nodo nodo, int valor) {
        if (nodo.getDato() == valor) {
            return nodo;
        } else if (valor <= nodo.getDato()) {
            if (nodo.getIzq() != null) {
                return buscar(nodo.getIzq(), valor);
            }
        } else {
            if (nodo.getDer() != null) {
                return buscar(nodo.getDer(), valor);
            }
        }
        return null;
    }
    
    public void eliminar(int valor) {
        if (raiz.getDer() != null) {
            raiz = raiz.getDer();
        } else if (raiz.getDer() != null) {
            raiz = raiz.getDer();
            Nodo aux = raiz;
            while (raiz.getDer().getDato() != valor) {
                aux = aux.getDer();
            }
            aux.setDer(aux.getDer().getDer().getIzq());
            aux.getDer().getDer().setIzq(aux.getIzq().getDer());
        }
    }
    
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
