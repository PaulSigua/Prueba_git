/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPersona;
import java.util.Random;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author UPS
 */
public class VistaPersona {
    public Scanner teclado;
    public ControladorPersona controladorPersona;
    public Random random;
    
    public VistaPersona(){
        teclado = new Scanner(System.in);
        controladorPersona = new ControladorPersona();
        random = new Random();
    }
    public void menu(){
        int opc = 0;
        do {            
            System.out.println("1. Generar\n2. Atender \n3. Listar \n0. Salir");
            opc = teclado.nextInt();
            switch(opc) {
                case 1: generarPersonas(); break;
                case 2: atender(); break;
                case 3: listar(); break;
            }
        } while (opc != 0);
    }
    public void generarPersonas(){
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona(i, generarPlaca(), random.nextInt(5));
            controladorPersona.encolar(p);
        }
    }
    public String generarNumeros(){
        String placa = "";
        for (int i = 0; i < 4; i++) {
            placa += random.nextInt(10);
        }
        return placa;
    }
    
    public String generarLetra(){
        String placa ="";
        for(int i = 0; i < 3; i++){
            placa += "" + (char)(random.nextInt(27)+'A');
        }
        return placa;
    }
    
    public String generarPlaca(){
        return generarLetra() + "-" + generarNumeros();
    }
    
    public void atender(){
        while (!controladorPersona.getColaPersona().isEmpty()) {
            Persona p = controladorPersona.desencolar();
            System.out.println("Atendiendo : " + p.getNombre() + " -> Prioridad : " + p.getPrioridad());
        }
    }
    public void listar(){
        controladorPersona.getColaPersona().forEach(p -> System.out.println(p));
    }
    
}
