package Hash;
import LINKEDlist.ListLinked;

public class HashO<T> {
    private ListLinked<Register<T>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        this.table = new ListLinked[size];

        for (int i = 0; i < size; i++) {
            table[i] = new ListLinked<>();
        }
    }

    
    private int hash(int key) {
        return Math.abs(key) % size;
    }

    
    public void insert(Register<T> reg) {
        int index = hash(reg.getKey());
        table[index].insertLast(reg);
    }

    
    public Register<T> search(int key) {
        int index = hash(key);

        for (int i = 0; i < table[index].size(); i++) {
            Register<T> r = table[index].get(i);
            if (r.getKey() == key) {
                return r;
            }
        }

        return null;
    }

 
    public void delete(int key) {
        int index = hash(key);

        for (int i = 0; i < table[index].size(); i++) {
            Register<T> r = table[index].get(i);

            if (r.getKey() == key) {
                table[index].removeNode(r);
                return;
            }
        }
    }

    
    public void printTable() {
        System.out.println("\n===== HASH ABIERTO =====");

        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "] -> ");
            table[i].print();
        }

        System.out.println("========================");
    }
    
    public ListLinked<Register<T>> getBucket(int index) {
        return table[index];
    }
}
