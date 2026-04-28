public class Cancion {
	private String titulo;
	private String artista;
	private int duracionSeg;
	
	public Cancion(String titulo, String artista, int duracionSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
    }
	
	public String getTitulo() {
        return this.titulo;
    }

    public String getArtista() {
        return this.artista;
    }

    public int getDuracionSeg() {
        return this.duracionSeg;
    }
    
    @Override
    public String toString() {
    	return this.titulo + " - " + this.artista + " (" + this.duracionSeg + "s)";
    }

}
