import java.util.ArrayList;

class Busqueda_binaria {

    public int Busqueda(ArrayList<Integer> lista, int item) {
        int primero = 0;
        int ultimo = lista.size() - 1;

        while (primero <= ultimo) {
            int mitad = (primero + ultimo) / 2;
            int supuesto = lista.get(mitad);

            if (supuesto == item) {
                return mitad;
            }

            if (supuesto > item) {
                ultimo = mitad - 1;
            } else {
                primero = mitad + 1;
            }
        }

        return -1; // no se encontro el elemento que se busca
    }
}

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        //Es necesario una lista ordenada
        numeros.add(1);
        numeros.add(2);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);

        Busqueda_binaria busqueda1 = new Busqueda_binaria();

        int resultado = busqueda1.Busqueda(numeros, 5); // item que se busca

        if (resultado != -1) {
            System.out.println("Elemento encontrado en posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
