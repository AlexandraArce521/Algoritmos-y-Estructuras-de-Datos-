package AVLTREE;
import Exceptions.*;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        System.out.println("********** CASOS DE PRUEBA — ÁRBOL AVL **********");

        System.out.println("\n====| CASO 1: Inserción sin rotación |====");
        System.out.println("Insertando: 30, 20, 40");
        try {
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();
        


        System.out.println("\n====| CASO 2: Rotación Simple Derecha (RSR) |====");
        System.out.println("Insertando: 10 -> provoca RSR sobre nodo 30");
        try {
            tree.insert(10);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();



        
        System.out.println("\n====| CASO 3: Preparación RSL — insertar 50 |====");
        try {
            tree.insert(50);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();



        System.out.println("\n====| CASO 4: Rotación Simple Izquierda (RSL) |====");
        System.out.println("Insertando: 60 -> provoca RSL sobre nodo 40");
        try {
            tree.insert(60);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();



        System.out.println("\n====| CASO 5: Rotación Doble Derecha (RDR) |====");
        System.out.println("Insertando: 25 -> provoca RDR (RSL+RSR)");
        try {
            tree.insert(25);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();



        System.out.println("\n====| CASO 6: Rotación Doble Izquierda (RDL) |====");
        System.out.println("Insertando: 55 -> provoca RDL (RSR+RSL)");
        try {
            tree.insert(55);
        } catch (ItemDuplicated e) {
            System.out.println("Duplicado: " + e.getMessage());
        }
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());
        tree.drawBST();


        System.out.println("\nARBOL ANTES DE ELIMINACIONES:");
        System.out.println("Nodos: " + tree.countAllNodes());
        System.out.println("InOrden: " + tree.getInOrder());
        tree.drawBST();



        
        System.out.println("\n====| CASO 7: Eliminación de nodo hoja |====");
        System.out.println("Eliminando: 10 -> nodo sin hijos");
        tree.drawBST();
        try { tree.delete(10); } catch (ExceptionIsEmpty e) { System.out.println(e.getMessage()); }
        System.out.println("Árbol DESPUÉS:");
        tree.drawBST();
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());



        
        System.out.println("\n====| CASO 8: Eliminación nodo con un hijo |====");
        System.out.println("Eliminando: 25 -> un único hijo");
        tree.drawBST();
        try { tree.delete(25); } catch (ExceptionIsEmpty e) { System.out.println(e.getMessage()); }
        System.out.println("Árbol DESPUÉS:");
        tree.drawBST();
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());



        
        System.out.println("\n====| CASO 9: Eliminación nodo con dos hijos |====");
        System.out.println("Eliminando: 30 -> sucesor inorden reemplaza al nodo");
        tree.drawBST();
        try { tree.delete(30); } catch (ExceptionIsEmpty e) { System.out.println(e.getMessage()); }
        System.out.println("Árbol DESPUÉS:");
        tree.drawBST();
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());



        
        System.out.println("\n====| CASO 10: Eliminación con rotación |====");
        System.out.println("Eliminando: 20 -> provoca desbalance y rotación");
        tree.drawBST();
        try { tree.delete(20); } catch (ExceptionIsEmpty e) { System.out.println(e.getMessage()); }
        System.out.println("Árbol DESPUÉS:");
        tree.drawBST();
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());



        
        System.out.println("\n====| CASO 11: Eliminación con más de una rotación |====");
        System.out.println("Eliminando: 55 -> rebalanceo múltiple en cascada");
        tree.drawBST();
        try { tree.delete(55); } catch (ExceptionIsEmpty e) { System.out.println(e.getMessage()); }
        System.out.println("Árbol DESPUÉS:");
        tree.drawBST();
        System.out.println("InOrden: " + tree.getInOrder());
        System.out.println("¿BST válido? " + tree.isValidBST());



        
        System.out.println("\n ================================================ ");
        System.out.println("               RESUMEN FINAL                       ");
        System.out.println(" ================================================ ");
        System.out.println("Nodos restantes : " + tree.countAllNodes());
        System.out.println("Altura del árbol: " + tree.height(tree.getRoot().data));
        System.out.println("InOrden final   : " + tree.getInOrder());
        System.out.println("PreOrden final  : " + tree.getPreOrder());
        System.out.println("PostOrden final : " + tree.getPostOrder());
        System.out.println("¿BST válido?    : " + tree.isValidBST());
        System.out.println("\nÁrbol final:");
        tree.drawBST();



        
        System.out.println("\n\n====| EJERCICIO 4: Recorrido por Amplitud Recursivo |====");

        AVLTree<Integer> avl1 = new AVLTree<>();
        AVLTree<Integer> avl2 = new AVLTree<>();

        try {
            for (int x : new int[]{30, 20, 40, 10, 25, 50}) avl1.insert(x);

            System.out.println("\n--- AVL 1: {30,20,40,10,25,50} ---");
            avl1.drawBST();
            System.out.println("InOrden  : " + avl1.getInOrder());
            System.out.println("PreOrden : " + avl1.getPreOrder());
            System.out.print("Amplitud : ");
            avl1.recorridoPorAmplitudRecursivo();

            for (int x : new int[]{50, 30, 70, 20, 40, 60, 80}) avl2.insert(x);

            System.out.println("\n--- AVL 2: {50,30,70,20,40,60,80} ---");
            avl2.drawBST();
            System.out.println("InOrden  : " + avl2.getInOrder());
            System.out.println("PreOrden : " + avl2.getPreOrder());
            System.out.print("Amplitud : ");
            avl2.recorridoPorAmplitudRecursivo();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        
        System.out.println("\n\n====| EJERCICIO 5: BFS Recursivo — orden 50,30,70,20,40,60,80,10,25,65 |====");

        AVLTree<Integer> avl3 = new AVLTree<>();
        AVLTree<Integer> avl4 = new AVLTree<>();

        try {
            for (int x : new int[]{50, 30, 70, 20, 40, 60, 80, 10, 25, 65}) avl3.insert(x);

            System.out.println("\n--- AVL 3: {50,30,70,20,40,60,80,10,25,65} ---");
            avl3.drawBST();
            System.out.println("InOrden  : " + avl3.getInOrder());
            System.out.println("PreOrden : " + avl3.getPreOrder());
            System.out.print("Amplitud : ");
            avl3.recorridoPorAmplitudRecursivo();

            for (int x : new int[]{40, 20, 60, 10, 30, 50, 70}) avl4.insert(x);

            System.out.println("\n--- AVL 4: {40,20,60,10,30,50,70} ---");
            avl4.drawBST();
            System.out.println("InOrden  : " + avl4.getInOrder());
            System.out.println("PreOrden : " + avl4.getPreOrder());
            System.out.print("Amplitud : ");
            avl4.recorridoPorAmplitudRecursivo();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        
        System.out.println("\n\n====| EJERCICIO 6: Recorrido PreOrden |====");

        AVLTree<Integer> avl5 = new AVLTree<>();
        AVLTree<Integer> avl6 = new AVLTree<>();

        try {
            for (int x : new int[]{30, 20, 40, 10, 25, 50}) avl5.insert(x);

            System.out.println("\n--- AVL 5: {30,20,40,10,25,50} ---");
            avl5.drawBST();
            System.out.print("PreOrden : ");
            avl5.recorridoPreOrden();

            for (int x : new int[]{50, 30, 70, 20, 40, 60, 80}) avl6.insert(x);

            System.out.println("\n--- AVL 6: {50,30,70,20,40,60,80} ---");
            avl6.drawBST();
            System.out.print("PreOrden : ");
            avl6.recorridoPreOrden();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        
        System.out.println("\n\n====| EJERCICIO 7: Inserciones con rotaciones y eliminaciones |====");

        AVLTree<Integer> avl7 = new AVLTree<>();

        try {
            // Rotación Doble Izquierda-Derecha
            avl7.insert(30);
            System.out.println("Insertado: 30"); avl7.drawBST();

            avl7.insert(10);
            System.out.println("Insertado: 10"); avl7.drawBST();

            avl7.insert(20);
            System.out.println("Insertado: 20 >> Rotación Doble Izq-Der");
            avl7.drawBST();

            // Rotación Simple Izquierda
            avl7.insert(40);
            System.out.println("Insertado: 40"); avl7.drawBST();

            avl7.insert(50);
            System.out.println("Insertado: 50 >> Rotación Simple Izquierda");
            avl7.drawBST();

            // Rotación Doble Derecha-Izquierda
            avl7.insert(45);
            System.out.println("Insertado: 45 >> Rotación Doble Der-Izq");
            avl7.drawBST();

            System.out.println("\nInOrden  : " + avl7.getInOrder());
            System.out.println("PreOrden : " + avl7.getPreOrder());

            // Eliminaciones
            System.out.println("\n--- Eliminaciones ---");

            avl7.delete(10);
            System.out.println("Eliminado: 10 (hoja)"); avl7.drawBST();

            avl7.delete(50);
            System.out.println("Eliminado: 50 (un hijo)"); avl7.drawBST();

            avl7.delete(30);
            System.out.println("Eliminado: 30 (dos hijos) >> Verificando rotaciones");
            avl7.drawBST();

            System.out.println("\nInOrden final : " + avl7.getInOrder());
            System.out.println("¿AVL válido?  : " + avl7.isValidBST());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
