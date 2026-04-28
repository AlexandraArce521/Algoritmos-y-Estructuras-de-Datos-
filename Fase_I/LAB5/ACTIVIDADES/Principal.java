public class Principal {
	public static void main(String[] args) {
		GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
		
		Tarea t1 = new Tarea("Diseñar DB", 2, "pendiente");
		Tarea t2 = new Tarea("Deploy produccion", 1, "pendiente");
		Tarea t3 = new Tarea("Documentar API", 3, "completada");
		Tarea t4 = new Tarea("Code review", 2, "pendiente");
		Tarea t5 = new Tarea("Corregir bug #42", 1, "completada");
		
		gestor.agregarTarea(t1);
		gestor.agregarTarea(t2);
		gestor.agregarTarea(t3);
		gestor.agregarTarea(t4);
		gestor.agregarTarea(t5);
		
		gestor.imprimirTareas();
		System.out.print("\nDESPUES DE ELIMINAR ->");
		gestor.eliminarTarea(t4);
		gestor.imprimirTareas();
		
		System.out.println("\nBuscando tarea Deploy produccion: " + gestor.contieneTarea(t2));
		
		System.out.println("\nMas prioritaria: " + gestor.obtenerTareaMasPrioritaria());
		
		gestor.invertirTareas();
		System.out.println("\nLISTA INVERTIDA ->");
		gestor.imprimirTareas();
		
		GestorDeTareas<Tarea> completitas = new GestorDeTareas<>();
		transferir(gestor, completitas);
		
		System.out.print("\nTAREAS completadas:");
        completitas.imprimirTareas();

        System.out.print("\nTAREAS restantes:");
        gestor.imprimirTareas();
	}
	
	public static void transferir(GestorDeTareas<Tarea> origen, GestorDeTareas<Tarea> dest ) {
		Node<Tarea> actual = origen.listaTareas.first;
		
		while(actual != null) {
			if (actual.dato.getEstado().equals("completada")) {
                dest.agregarTarea(actual.dato);
                origen.eliminarTarea(actual.dato);
            }
            actual = actual.next;
        }
	}
}
