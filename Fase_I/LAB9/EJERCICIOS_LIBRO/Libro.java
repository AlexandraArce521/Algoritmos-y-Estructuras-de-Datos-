package EjercicioLibro;

public class Libro implements Comparable<Libro> {
    public String isbn;
    public String titulo;
    public String autor;
    public int añoPublicacion;

    public Libro(String isbn, String titulo, String autor, int añoPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    @Override
    public int compareTo(Libro otro) {
        return this.isbn.compareTo(otro.isbn);
    }

    @Override
    public String toString() {
        return this.isbn + " - " + this.titulo + " - " + this.autor + " - " + this.añoPublicacion;
    }
}
