/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aplaza
 */
public class Invoker {

	private List<IOperacion> operaciones = new ArrayList<>();

	public void recibirOperacion(IOperacion operacion) {
		this.operaciones.add(operacion);
	}

	public void realizarOperaciones() 
        {
		this.operaciones.forEach(x -> x.execute());
		this.operaciones.clear();
	}

}
