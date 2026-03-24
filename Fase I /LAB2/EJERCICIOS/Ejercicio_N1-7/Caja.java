public class Caja <T>{
	private String color;
	private T objeto;
	
	public Caja(String color, T objeto) {
		this.color = color;
		this.objeto = objeto;
	}
	
	public T getObjeto() {
		return this.objeto;
	}
	
	public String getColor() {
		return this.color;
	}
	
	@Override
	public String toString() {
		return this.objeto.toString();
	}
}
