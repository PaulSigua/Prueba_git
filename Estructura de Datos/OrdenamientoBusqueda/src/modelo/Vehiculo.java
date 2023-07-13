package modelo;

public class Vehiculo implements Comparable{
    private long id;
    private String placa;
    private double valor;

    public Vehiculo(long id, String placa, double valor) {
        this.id = id;
        this.placa = placa;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", placa=" + placa + ", valor=" + valor + '}';
    }

    @Override
    public int compareTo(Object obj) {
        Vehiculo vehiculo = (Vehiculo) obj;
        return vehiculo.getPlaca().compareTo(placa);
    }
    
    
    
}
