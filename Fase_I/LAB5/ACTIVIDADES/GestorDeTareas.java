public class GestorDeTareas<T extends Tarea> {
	ListLinked<T> listaTareas;
	
	GestorDeTareas(){
		this.listaTareas = new ListLinked<>();
	}
	
	public void agregarTarea(T tarea) {
		listaTareas.insertLast(tarea);
	}
	//==========================================
	public boolean eliminarTarea(T tarea) {
		return listaTareas.removeNode(tarea);
	}
	//==========================================
	public boolean contieneTarea(T tarea) {
		return listaTareas.search(tarea);
	}
	//==========================================
	public void imprimirTareas() {
		listaTareas.print();
	}
	//===========================================
	public int contarTareas() {
		return listaTareas.length();
	}
	//===========================================
	public T obtenerTareaMasPrioritaria() {  
		if (this.listaTareas.isEmptyList()) {
	        return null;
	    }

		Node<T> actual = this.listaTareas.first;
	    T mejor = actual.dato;
	    while (actual != null) {
	        if (actual.dato.getPrioridad() < mejor.getPrioridad()) {
	            mejor = actual.dato;
	        }
	        actual = actual.next;
	    }
	    
	    return mejor;
	}
	//===========================================
	public void invertirTareas() {
		listaTareas.reverse();
	}
}