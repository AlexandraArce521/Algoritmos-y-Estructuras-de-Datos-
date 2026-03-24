import java.util.*;   

public class PowerStation <T extends Cargable> {
	private List <T> dispositivosConectados = new ArrayList<>();
	private int maxDis = 0;
	
	public PowerStation(int maxDis) {
		this.setMaxDis(maxDis);
	}
	
	public void conectar(T dispositivo) {
		if (dispositivosConectados.size() < maxDis) {
		    dispositivosConectados.add(dispositivo);
		}	
	}
	
	public double calcularConsumo() {
		double suma = 0.0;
		for (T d: dispositivosConectados) {
			suma += d.getConsumoVatios();
		}
		
		return suma;

	}
	
	public boolean buscarDispositivo(T prototipo) {
		
		for (int i = 0; i < dispositivosConectados.size(); i++) {
			
			if (prototipo == null) return false;
			
			if (dispositivosConectados.get(i).equals(prototipo)) {
				System.out.println("(°)Dispositivo en Estacion de Carga");
				return true;
			} 
		}
		System.out.println("(!) No se encontro Dispositivo en Estacion de Carga");
		return false;
	}
	
	public void mostrarReporte() {
	    System.out.println("Posición \t|\tConsumo de Bateria");
		System.out.println("_______________________________________\n");
		for(int i = 0; i < dispositivosConectados.size(); i++) {
			System.out.println(i + "\t\t"+dispositivosConectados.get(i).getConsumoVatios()+"\n");
		}
		
	}

	public List <T> getDispositivosConectados() {
		return dispositivosConectados;
	}

	public void setDispositivosConectados(List <T> dispositivosConectados) {
		this.dispositivosConectados = dispositivosConectados;
	}

	public int getMaxDis() {
		return maxDis;
	}

	public void setMaxDis(int maxDis) {
		this.maxDis = maxDis;
	}
}
