package Hash;

public class TestHashC {
	public static void main(String[] args) {
        HashC<String> hash = new HashC<>(11);
        
        hash.insert(new Register<>(34, "Ana"));
        hash.insert(new Register<>(3, "Luis"));
        hash.insert(new Register<>(7, "Maria"));
        hash.insert(new Register<>(30, "Pedro"));
        hash.insert(new Register<>(11, "Jose"));
        hash.insert(new Register<>(8, "Lucia"));
        hash.insert(new Register<>(7, "Carlos")); 
        hash.insert(new Register<>(23, "Diego"));
        hash.insert(new Register<>(41, "Sofia"));
        hash.insert(new Register<>(16, "Miguel"));
        hash.insert(new Register<>(34, "Elena"));  

        System.out.println("\n=== TABLA HASH (ANTES DE ELIMINAR) ===");
        hash.printTable();

        System.out.println("\nEliminando clave 30...");
        hash.delete(30);

        System.out.println("\n=== TABLA HASH (DESPUÉS DE ELIMINAR) ===");
        hash.printTable();

    
        System.out.println("\nBuscando clave 23...");
        Register<String> result = hash.search(23);

        if (result != null) {
            System.out.println("Encontrado: " + result);
        } else {
            System.out.println("No encontrado");
        }
    }
}
