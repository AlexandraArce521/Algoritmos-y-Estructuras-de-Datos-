
public class Smartphone implements Cargable {
	
	private String modelo;
	private int vatios;
	private int nivelBateria;
	
	public Smartphone(String modelo, int vatios) {
		this.modelo = modelo;
		this.vatios = vatios;
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
		if (this == obj) {
			return true;
		}
		
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Smartphone otroCelular = (Smartphone) obj;
		if(this.vatios == otroCelular.getVatios() && this.modelo.equals(otroCelular.getModelo())){
			return true;
		}
		return false;
	}
	
	public void mostrarEstado() {
		System.out.println("Nivel de bateria: " + nivelBateria +"%\n");
	}

}
