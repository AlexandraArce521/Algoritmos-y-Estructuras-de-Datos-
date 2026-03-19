import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);                                        
        AnalizadorMinero analizador = new AnalizadorMinero();                           
        
        try {                        
            System.out.print("Ingrese la ruta del archivo (.txt): ");                    
            String ruta = lector.nextLine();                                             
            analizador.cargarDesdeArchivo(ruta);                                         
            
            System.out.print("Ingrese el tamaño de la subregión (tamaño: terreno de 3x3): ");
            int k = lector.nextInt();                                                     
            
            analizador.ejecutarAnalisis(k);                                              
            
            } catch (Exception e) {
                System.out.println("(!) Error durante la ejecución: " + e.getMessage());     
            } finally {
                lector.close();                                                         
        }
    }
}
