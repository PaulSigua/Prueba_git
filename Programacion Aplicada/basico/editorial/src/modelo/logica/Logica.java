/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.sql.ResultSet;
import modelo.dao.EjemplarDaoImpl;

/**
 *
 * @author aplaza
 */
public class Logica {

    EjemplarDaoImpl ejemplarDao = new EjemplarDaoImpl();

    public void realizarPrueba() {
        ejemplarDao.realizarPrueba();
    }

    public ResultSet buscarRevista(int codigo){
        return ejemplarDao.buscarRevista(codigo);
    }
    
    public boolean agregarRevista(int codEjemplar, String fecha, int numPag, int numVentas, int codRev){
        return ejemplarDao.agregarEjemplar(codEjemplar, fecha, numPag, numVentas, codRev);
    }

}
