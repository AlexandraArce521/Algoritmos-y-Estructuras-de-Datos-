
public class Zona {
    private String mineral;
    private double cantidad;
    private double pureza;

    public Zona(String mineral, double cantidad, double pureza) {
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }

    public String getMineral() {
        return this.mineral;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public double getPureza() {
        return this.pureza;
    }

    public double getValor() {
        return this.cantidad * this.pureza;
    }

    @Override
    public String toString() {
        return "[ " + this.mineral + ", cantidad: " + this.cantidad + ", pureza: " + this.pureza + " ]";
    }
}
