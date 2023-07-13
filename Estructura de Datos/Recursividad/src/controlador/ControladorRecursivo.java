/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author UPS
 */
public class ControladorRecursivo {
    
    public void recorrerRecursivoAtras(int valor){
        if(valor<= 0)
            return;
        System.out.println(valor);
        recorrerRecursivoAtras(valor);
    }
    public int fibonassi(int n){
        if(n<2) return n;
        return fibonassi(n-1) + fibonassi(n-2);
    }
    public int fibo(int n){
        if(n<2) return n;
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i-1] + fib[i-2];
        return fib[n];
    }
    
}
