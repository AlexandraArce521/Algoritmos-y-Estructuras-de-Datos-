import java.util.ArrayList;

public class Caja<T extends Comparable<T>> {
    private String color;
    private T objeto;
    private ArrayList<T> lista = new ArrayList<>();

    public Caja(String color, T objeto) {
        this.color = color;
        this.objeto = objeto;
    }

    public T getObjeto() {
        return this.objeto;
    }

    public String getColor() {
        return this.color;
    }

    public void add(T objeto) {
        lista.add(objeto);
    }

    public ArrayList<T> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caja color: ").append(color).append("\n");
        sb.append("Objeto principal: ").append(objeto).append("\n");
        sb.append("Lista de objetos: ").append(lista);
        return sb.toString();
    }
}
