public class Chocolatina implements Comparable<Chocolatina> {
	private String marca;
	
	public Chocolatina(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(!(obj instanceof Chocolatina))
			return false;
		
		Chocolatina ch = (Chocolatina) obj;
		return this.marca.equals(ch.getMarca());
	}

	@Override
	public int compareTo(Chocolotina otro) {
		return 0;	 //Falta
	}
	
	@Override
	public String toString() {
		return "Chocolatina: " + this.marca;
	}
}
