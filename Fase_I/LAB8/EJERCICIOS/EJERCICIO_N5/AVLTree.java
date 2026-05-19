package avltree;

public class AVLTree {

    private NodoAVL raiz;

    private int altura(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return nodo.altura;
    }

    private int balance(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return altura(nodo.der) - altura(nodo.izq);
    }

    private void actualizarAltura(NodoAVL nodo) {

        nodo.altura = 1 +
                Math.max(altura(nodo.izq),
                         altura(nodo.der));
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {

        NodoAVL y = x.der;
        NodoAVL temp = y.izq;

        y.izq = x;
        x.der = temp;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    private NodoAVL rotarDerecha(NodoAVL y) {

        NodoAVL x = y.izq;
        NodoAVL temp = x.der;

        x.der = y;
        y.izq = temp;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }


    public void insertar(int dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoAVL insertar(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return new NodoAVL(dato);
        }

        if (dato < nodo.dato) {
            nodo.izq = insertar(nodo.izq, dato);
        }
        else if (dato > nodo.dato) {
            nodo.der = insertar(nodo.der, dato);
        }
        else {
            return nodo;
        }

        actualizarAltura(nodo);

        int bf = balance(nodo);

        // Caso Derecha-Derecha
        if (bf > 1 && dato > nodo.der.dato) {
            return rotarIzquierda(nodo);
        }

        // Caso Izquierda-Izquierda
        if (bf < -1 && dato < nodo.izq.dato) {
            return rotarDerecha(nodo);
        }

        // Caso Izquierda-Derecha
        if (bf < -1 && dato > nodo.izq.dato) {

            nodo.izq = rotarIzquierda(nodo.izq);

            return rotarDerecha(nodo);
        }

        // Caso Derecha-Izquierda
        if (bf > 1 && dato < nodo.der.dato) {

            nodo.der = rotarDerecha(nodo.der);

            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // =========================================
    // RECORRIDO POR AMPLITUD RECURSIVO
    // =========================================

    public void recorridoAmplitud() {

        int h = alturaTotal(raiz);

        for (int nivel = 0; nivel < h; nivel++) {

            imprimirNivel(raiz, nivel);
        }

        System.out.println();
    }


    private int alturaTotal(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        int altIzq = alturaTotal(nodo.izq);
        int altDer = alturaTotal(nodo.der);

        return 1 + Math.max(altIzq, altDer);
    }


    private void imprimirNivel(NodoAVL nodo, int nivel) {

        if (nodo == null) {
            return;
        }

        if (nivel == 0) {

            System.out.print(nodo.dato + " ");
        }
        else {

            imprimirNivel(nodo.izq, nivel - 1);
            imprimirNivel(nodo.der, nivel - 1);
        }
    }


    public void preOrden() {

        preOrden(raiz);

        System.out.println();
    }

    private void preOrden(NodoAVL nodo) {

        if (nodo != null) {

            System.out.print(nodo.dato + " ");

            preOrden(nodo.izq);
            preOrden(nodo.der);
        }
    }
}
