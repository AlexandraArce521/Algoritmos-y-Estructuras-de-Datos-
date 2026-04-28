public class Tarea implements Comparable<Tarea>{
	private String titulo;
	private int prioridad;
	private String estado;
	
	Tarea(String titulo, int prioridad, String estado){
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.estado = estado;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setTitulo(String dato) {
		this.titulo = dato;
	}
	
	public void setPrioridad(int dato) {
		this.prioridad = dato;
	}
	
	public void setEstado(String dato) {
		this.estado = dato;
	}
	
	@Override
	public int compareTo(Tarea otra) {
		return Integer.compare(this.prioridad, otra.prioridad);
	}
	
	@Override
	public String toString() {
		return "[" + this.titulo + " | Prioridad: " + this.prioridad + " | Estado: " + this.estado + "]";
	}
}
