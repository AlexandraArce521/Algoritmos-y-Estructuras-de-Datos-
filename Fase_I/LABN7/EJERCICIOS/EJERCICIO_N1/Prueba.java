package bstreelinklistinterfgeneric;

import Exceptions.*;

public class Prueba {

    public static boolean sameArea(LinkedBST<?> a, LinkedBST<?> b) {
        return a.areaBST() == b.areaBST();
    }

    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();
        //=============================================================
        System.out.println("=== INSERTANDO ________");
        try {
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            System.out.println("Elementos insertados: 50, 30, 70, 20, 40, 60, 80");
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bst.insert(50);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado detectado (50) " + e.getMessage());
        }

        //====================================================================
        System.out.println("\n=== RECORRIDOS __________");
        System.out.println("InOrder  : " + bst.getInOrder());
        System.out.println("PreOrder : " + bst.getPreOrder());
        System.out.println("PostOrder : " + bst.getPostOrder());

        //=====================================================================
        System.out.println("\n=== BUSQUEDA _____________");
        try {
            System.out.println("Buscar 40: " + bst.search(40));
            System.out.println("Buscar 99: " + bst.search(99));
        } catch (ItemNoFound e) {
            System.out.println("No encontrado: " + e.getMessage());
        }

        //=============================================================
        System.out.println("\n=== HEIGHT ___________");
        System.out.println("Altura del arbol (raíz 50): " + bst.height(50));
        System.out.println("Altura subarbol raíz 30: " + bst.height(30));
        System.out.println("Altura nodo hoja 20: " + bst.height(20));
        System.out.println("Altura nodo inexistente 99: " + bst.height(99));

        //==================================================
        System.out.println("\n=== AMPLITUDE ___________");
        for (int i = 0; i <= 3; i++) {
            System.out.println("Amplitud nivel " + i + ": " + bst.amplitude(i));
        }

        //=====================================
        System.out.println("\n=== CONTANDO ____________");
        System.out.println("Total nodos: " + bst.countAllNodes());
        System.out.println("Nodos no-hoja: " + bst.countNodes());

        //====================================
        System.out.println("\n=== AREA __________");
        System.out.println("Area: " + bst.areaBST());

        // ── SAME AREA ────────────────────────────────────────────
        System.out.println("\n====== SAME AREA ======");
        LinkedBST<Integer> bst2 = new LinkedBST<>();
        try {
            bst2.insert(10);
            bst2.insert(5);
            bst2.insert(15);
            bst2.insert(3);
            bst2.insert(7);
            bst2.insert(12);
            bst2.insert(20);
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
        System.out.println("BST2 InOrder: " + bst2.toString());
        System.out.println("Área BST2   : " + bst2.areaBST());
        System.out.println("Misma área? : " + sameArea(bst, bst2));

        // ================================
        System.out.println("\n===VALID BST _____________");
        System.out.println("¿BST valido?: " + bst.isValidBST());

        //===========================================
        System.out.println("\n=== DRAW BST _____________");
        bst.drawBST();

        // ==============================================
        System.out.println("\n=== PARENTHESIZE __________");
        bst.parenthesize();

        //=============================================
        System.out.println("\n=== DELETE _______________");
        try {
            bst.delete(30);
            System.out.println("Eliminado 30. InOrder: " + bst.toString());
            bst.delete(50);
            System.out.println("Eliminado 50 (raíz). InOrder: " + bst.toString());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }

        //===============================================
        System.out.println("\n=== DESTRUCCION DEL ARBOL _________");
        try {
            bst.destroyNodes();
            System.out.println("Árbol destruido. ¿isEmpty?: " + bst.isEmpty());
            bst.destroyNodes(); 
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción correcta al destruir árbol vacío: " + e.getMessage());
        }
    }
}
