import java.util.ArrayList;

public class Cajoneria<T extends Comparable <T>>{
	private ArrayList<Caja<T>> caja = new ArrayList<Caja<T>>();
	private int tope;
	
	public Cajoneria(int tope) {
		this.tope = tope;
	}
	
	public void add(Caja<T> objeto) {
		if (caja.size() < tope) {
			caja.add(objeto);
		} else {
			throw new RuntimeException("no caben mas");
		}
	}
	
	public String search(T elemento) {
		for(int i = 0; i < caja.size(); i++) {
			if(caja.get(i).getObjeto().equals(elemento)) {
				return i + " " + caja.get(i).getColor();
			}
		}
		return "No existe";
	}
	
	public T delete(T elemento) {
		for(int i = 0; i < caja.size(); i++) {
			if(caja.get(i).getObjeto().equals(elemento)) {
				T eliminado = caja.get(i).getObjeto();
				caja.remove(i);
				return eliminado;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String mensaje;
		mensaje = "Posicion    Color Caja    Objeto\n";
		mensaje += "_________________________________\n";
		for(int i = 0 ; i < caja.size(); i++) {
			mensaje += " " + i + "   " + caja.get(i).getColor() + "      " + caja.get(i) + "\n";
		}	
		return mensaje;
	} 
	
	public int contar(T elemento) {
		int contador = 0;
		for(int i = 0; i < caja.size(); i++) {
			if(caja.get(i).getObjeto().equals(elemento)) {
				contador += 1;
			}
		}
		return contador;
	}
	
	public ArrayList<Caja<T>> getCaja(){
		return this.caja;
	}
}
