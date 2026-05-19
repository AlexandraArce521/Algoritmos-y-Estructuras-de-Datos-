package EJERCICIO01;

public class Principal {
	public static void main(String[] args) {

		GestorTicketsAVL gestor = new GestorTicketsAVL();

		gestor.insertarTicket(30);
		gestor.insertarTicket(10);
		gestor.insertarTicket(20);
		gestor.insertarTicket(40);
		gestor.insertarTicket(50);
		gestor.insertarTicket(25);
		
		gestor.buscarTicket(20);
		gestor.buscarTicket(60);
		
		gestor.eliminarTicket(10);
		gestor.eliminarTicket(40);
		gestor.eliminarTicket(30);
	}
}

