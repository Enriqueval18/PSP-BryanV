import java.io.Serializable;
@SuppressWarnings("serial")

public class Factura implements  Serializable {
    private static final long serialVersionUID = 1L;
    String numerofactura;
    String fechafactura;
    double importe;
    String tipoiva;
    double iva;
    double importetotal;

    public Factura(String numerofactura, String fechafactura, double importe, String tipoiva){
        super();
        this.numerofactura = numerofactura;
        this.fechafactura = fechafactura;
        this.importe = importe;
        this.tipoiva = tipoiva;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getTipoiva() {
        return tipoiva;
    }

    public void setTipoiva(String tipoiva) {
        this.tipoiva = tipoiva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getImportetotal() {
        return importetotal;
    }

    public void setImportetotal(double importetotal) {
        this.importetotal = importetotal;
    }
}
