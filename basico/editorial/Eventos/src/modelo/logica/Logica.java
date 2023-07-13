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
public class Logica 
{
    EjemplarDaoImpl ejemplarDao=new EjemplarDaoImpl();
    
    public void conectar()
    {
        ejemplarDao.conectar();
    }
    
    public boolean ingresar(int codigo, String fecha, int numPaginas, int numVentas)
    {
        ejemplarDao.agregarEjemplar(codigo, fecha, numPaginas, numVentas);
        return true;
    }
    
    public ResultSet listar()
    {
        return ejemplarDao.listar();
    }
}
