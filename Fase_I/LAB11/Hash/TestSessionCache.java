package Hash;

public class TestSessionCache {
    public static void main(String[] args) throws InterruptedException {
        SessionCache cache = new SessionCache(5);

        cache.login("abc123", "Juan", "ADMIN", 5000);
        cache.login("xyz789", "Ana", "USER", 2000);   
        cache.login("lol456", "Luis", "USER", 10000); 

        System.out.println("\n=== INICIO DEL SISTEMA ===");
        cache.printTable();

        System.out.println("\nValidando sesiones:");
        System.out.println("abc123 -> " + cache.validate("abc123"));
        System.out.println("xyz789 -> " + cache.validate("xyz789"));
        System.out.println("lol456 -> " + cache.validate("lol456"));

        System.out.println("\nEsperando 3 segundos...");
        Thread.sleep(3000);

        System.out.println("\nValidación después de expiración:");

        System.out.println("xyz789 -> " + cache.validate("xyz789"));

        System.out.println("\nLogout de lol456");
        cache.logout("lol456");

        cache.printTable();

        cache.cleanExpired();

        System.out.println("\n=== DESPUÉS DE CLEAN EXPIRED ===");
        cache.printTable();

        System.out.println("\n=== ESTADO FINAL ===");
        System.out.println("abc123 -> " + cache.validate("abc123"));
        System.out.println("xyz789 -> " + cache.validate("xyz789"));
        System.out.println("lol456 -> " + cache.validate("lol456"));
    }
}