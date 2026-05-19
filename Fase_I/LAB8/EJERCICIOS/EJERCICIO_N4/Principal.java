public class Principal {
  public static void main(String[] args) {
    
            AVLTree arbol = new AVLTree();
    
            int datos[] = {
                50, 30, 70, 20, 40,
                60, 80, 10, 25, 65
            };
    
            for (int x : datos) {
                arbol.insertar(x);
            }
    
            System.out.println("RECORRIDO INORDEN:");
            arbol.inOrden();
    
            System.out.println();
    
            System.out.println("RECORRIDO PREORDEN:");
            arbol.preOrden();
    
            System.out.println();
    
            System.out.println("RECORRIDO POR AMPLITUD:");
            arbol.recorridoAmplitud();
        }
}
