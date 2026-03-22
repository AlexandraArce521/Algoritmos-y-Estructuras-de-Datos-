
public class Smartphone implements Cargable {
	
	private String modelo;
	private int vatios;
	private int cantidad;
	private int nivelBateria;
	
	public Smartphone(String modelo, int vatios, int cantidad) {
		this.modelo = modelo;
		this.vatios = vatios;
		this.cantidad = cantidad;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
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
	
	public boolean equals(Smartphone otraCelular) { // Se comprueba si la marca y los vatios son iguales
		if (this == otraCelular) {
			return true;
		}
		
		if(otraCelular == null || getClass() != otraCelular.getClass()) {
			return false;
		}
		
		if(this.vatios == otraCelular.vatios && this.modelo.equals(otraCelular.modelo)){
			return true;
		}
		return false;
	}
	
	public void mostrarEstado() {
		System.out.println("Nivel de bateria: " + nivelBateria +"%\n");
	}

}

