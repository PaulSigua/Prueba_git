
package hiloSincronizado;

/**
 *
 * @author LENOVO
 */
public class Cliente {
    private int numCuenta;
    private int saldo;
    private boolean estado;

    public Cliente(int numCuenta, int saldo, boolean estado) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.estado = estado;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
