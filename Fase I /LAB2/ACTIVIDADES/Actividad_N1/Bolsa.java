import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> bolsa = new ArrayList<T>();
    private int tope;

    public Bolsa(int tope) {
        this.tope = tope;
    }

    public void add(T objeto) {
        if (bolsa.size() < tope) {
            bolsa.add(objeto);
        } else {
            throw new RuntimeException("\n(!)No cabe más");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return bolsa.iterator();
    }
}
