package modelo;

/**
 *
 * @author ADMIN
 */
public class Orden 
{
    private String tipo;
    private String tamanio;
    private String borde;
    private String extra;

    public Orden(String tipo, String tamanio, String borde, String extra) {
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.borde = borde;
        this.extra = extra;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getBorde() {
        return borde;
    }

    public String getExtra() {
        return extra;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public void setBorde(String borde) {
        this.borde = borde;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    @Override
    public String toString()
    {
        return tipo+", "+tamanio+", "+borde+", "+extra;
    }
    
    public int getNCampos()
    {
        return 4;
    }
}
