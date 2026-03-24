public class Golosina implements Comparable <Golosina> {
	private String nombre;
	private double peso;
	
	public Golosina(String nombre, double peso) {
		this.nombre = nombre;
		this.peso = peso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(!(obj instanceof Golosina))
			return false;
		
		Golosina g = (Golosina) obj;
		return this.nombre.equals(g.getNombre()) && this.peso == g.getPeso();
	}
	@Override 
	public int compareTo(Golosina otro) {
		return 0; //Falta
	}
	
	@Override
	public String toString() {
		return "Golosina: " + this.nombre + ", peso: " + this.peso;
	}
}
