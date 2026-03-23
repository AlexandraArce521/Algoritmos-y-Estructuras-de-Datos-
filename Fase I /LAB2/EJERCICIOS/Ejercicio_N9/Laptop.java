
public class Laptop implements Cargable {
	private String marca;
	private int vatios;
	private int cantidad;
	private int nivelBateria;	
	
	
	public Laptop(String marca, int vatios, int cantidad, int nivelBateria) {
		this.marca = marca;
		this.vatios = vatios;
		this.cantidad = cantidad;
		this.nivelBateria = nivelBateria;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getVatios() {
		return vatios;
	}
	
	public void setVatios(int vatios) {
		this.vatios = vatios;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getConsumoVatios() {
		return vatios;
	}
	
	//No tendra set porque no se puede cambiar por el usuario
	public int getNivelBateria() {
		return nivelBateria;
	}
	
	public void cargar(int cantidad) {
		if(cantidad > 0) { // No se puede colocar una cantidad que baje la bateria 
			nivelBateria += cantidad;
			if(nivelBateria > 100) { // Si llega al 100% no cargara más
				nivelBateria = 100;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) { // Se comprueba si la marca y los vatios son iguales
		if (this == obj) { // Verificar si es el mismo objeto
			return true;
		}
		
		if(obj == null || getClass() != obj.getClass()) {  // Verificar si el objeto es nulo o no es de la misma clase
			return false;
		}
		
		Laptop otraCelular = (Laptop) obj; // Realizar el casting seguro y comparar los vatios y marca de las laptops
		if(this.vatios == otraCelular.getVatios() && this.marca == otraCelular.getMarca()){
			return true;
		}
		return false;
	}
	
	public void mostrarEstado() {
		System.out.println("Nivel de bateria: " + nivelBateria +"%\n");
	}

}
