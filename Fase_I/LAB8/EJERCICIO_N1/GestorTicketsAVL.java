package EJERCICIO01;
import Exceptions.*;
import AVLTREE.*;

public class GestorTicketsAVL {
	private AVLTree<Integer> arbol;

	public GestorTicketsAVL() {
		this.arbol = new AVLTree<>();
	}
	
	//=====================================
	public void insertarTicket(int ticket) {
		try {
			System.out.println("\nInsertando ticket: " + ticket);
			arbol.insert(ticket);
	         mostrarEstado();

		} catch (ItemDuplicated e) {
			System.out.println(e.getMessage());
		}
	}

	//=========================================
	public void buscarTicket(int ticket) {
		try {
			System.out.println("\nBuscando ticket: " + ticket);
			Integer encontrado = arbol.search(ticket);
			System.out.println("Ticket encontrado: " + encontrado);

		} catch (ItemNoFound e) {
			System.out.println("Ticket " + ticket + " no encontrado");
		}
	}
	
	//====================================
	public void eliminarTicket(int ticket) {
		try {
			System.out.println("\nEliminando ticket: " + ticket);
			arbol.delete(ticket);
			mostrarEstado();

		} catch (ExceptionIsEmpty e) {
			System.out.println(e.getMessage());
		}
	}
	
	//===========================================
	public void mostrarEstado() {
		System.out.println("\nArbol AVL:");
		arbol.drawBST();

		System.out.println("\nRecorrido InOrden:");
		System.out.println(arbol.getInOrder());

		System.out.println("\n¿Es BST valido?: " + arbol.isValidBST());
		System.out.println("=== === === === === === === === === ===\n");
	}
}
