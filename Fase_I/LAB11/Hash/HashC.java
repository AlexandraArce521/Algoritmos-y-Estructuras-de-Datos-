package Hash;

public class HashC<T> {
    private class Element<T> {
        Register<T> register;
        int status; 

        public Element() {
            register = null;
            status = 0;
        }
    }

    private Element[] table;
    private int size;

    @SuppressWarnings("unchecked")    
    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];

        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    
    private int hash(int key) {
        return Math.abs(key) % size;
    }
    
    //====
    private int middleSquareHash(int key) {
        long cuadrado = (long) key * key;
        String numero = String.valueOf(Math.abs(cuadrado));

        if (numero.length() < 3) {
            return Integer.parseInt(numero) % size;
        }

        int inicio = numero.length() / 2 - 1;
        int fin = inicio + 3;

        if (fin > numero.length()) {
            fin = numero.length();
        }

        int centrales = Integer.parseInt(numero.substring(inicio, fin));
        return centrales % size;
    }
    
    private int foldingHash(int key, int k) {
        String numero = String.valueOf(Math.abs(key));
        int suma = 0;

        for (int i = 0; i < numero.length(); i += k) {
            int fin = Math.min(i + k, numero.length());
            suma += Integer.parseInt(numero.substring(i, fin));
        }

        return suma % size;
    }
    
    //====
    
    public boolean insert(Register<T> reg) {
        int index = hash(reg.getKey());

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos].status != 1) {
                table[pos].register = reg;
                table[pos].status = 1;
                return true;
            }
        }

        System.out.println("Tabla llena.");
        return false;
    }

    
    public Register<T> search(int key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos].status == 0) {
                return null;                   
            }

            if (table[pos].status == 1 && table[pos].register.getKey() == key) {
                return table[pos].register;
            }
        }

        return null;
    }

    
    public boolean delete(int key) {
        int index = hash(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos].status == 0) {
                return false;
            }

            if (table[pos].status == 1 && table[pos].register.getKey() == key) {
                table[pos].register = null;
                table[pos].status = -1;      
                return true;
            }
        }

        return false;
    }

    public void printTable() {
        System.out.println("\n----- TABLA HASH -----");
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "] -> ");
            switch (table[i].status) {
                case 0:  
                	System.out.println("EMPTY");   
                	break;
                case -1: 
                	System.out.println("DELETED"); 
                	break;
                case 1:  
                	System.out.println(table[i].register); 
                	break;
            }
        }
        System.out.println("----------------------");
    }
}
