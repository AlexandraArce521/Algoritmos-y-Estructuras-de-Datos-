public class Principal {
	public static void main(String[] args) {
        ColaReproduccion<Cancion> misFavoritos = new ColaReproduccion<>("Spotify");
        
        misFavoritos.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        misFavoritos.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        misFavoritos.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        misFavoritos.agregarCancion(new Cancion("Believer", "Imagine Dragons", 204));
        misFavoritos.agregarCancion(new Cancion("Someone Like You", "Adele", 285));
        misFavoritos.agregarCancion(new Cancion("Numb", "Linkin Park", 185));
        
        misFavoritos.mostrarCola();
        misFavoritos.mostrarReproduccionActual();
        
        System.out.println("\n=== Avanzando 3 canciones ===");
        System.out.println("ACCTUAL: " + misFavoritos.reproducirSiguiente());
        System.out.println("ACCTUAL: " + misFavoritos.reproducirSiguiente());
        System.out.println("ACCTUAL: " + misFavoritos.reproducirSiguiente());
        misFavoritos.mostrarReproduccionActual();

        System.out.println("\n=== Retrocediendo 1 canción ===");
        System.out.println("ACCTUAL: " + misFavoritos.reproducirAnterior());
        misFavoritos.mostrarReproduccionActual();
        
        System.out.print("\n=== ... Mezclando ... ===");
        misFavoritos.mezclar();
        misFavoritos.mostrarCola();
        misFavoritos.mostrarReproduccionActual();
        
        int totalSegundos = misFavoritos.duracionTotal();
        System.out.printf("\nDuración total: %02d:%02d\n", totalSegundos / 60, totalSegundos % 60);

        
	}
}
