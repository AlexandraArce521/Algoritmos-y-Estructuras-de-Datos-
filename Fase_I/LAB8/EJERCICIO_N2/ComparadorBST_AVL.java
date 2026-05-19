package EJERCICIO02;
import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.*;
import AVLTREE.*;

public class ComparadorBST_AVL {
	private LinkedBST<Integer> bst;
	private AVLTree<Integer> avl;

	public ComparadorBST_AVL() {
		this.bst = new LinkedBST<>();
		this.avl = new AVLTree<>();
	}
	
	//=========================================
	public void insertarDatos(int[] datos) {
		System.out.println("===| INSERTANDO DATOS ==================");
		
		for (int x : datos) {
			try {
				bst.insert(x);
				avl.insert(x);

				System.out.println("Insertado: " + x);

        	} catch (ItemDuplicated e) {
        		System.out.println(e.getMessage());
        	}
		}
	}
	
	//=====================================
	public void mostrarBST() {
		System.out.println("\n========== BST ==========");
		bst.drawBST();
		System.out.println("\nRecorrido InOrden:");
		System.out.println(bst.getInOrder());
		
		System.out.println("\nAltura BST: " + bst.height(bst.getRoot().data));
	}

	//===================================
	public void mostrarAVL() {
		System.out.println("\n========== AVL ==========");
		avl.drawBST();
		System.out.println("\nRecorrido InOrden:");
		System.out.println(avl.getInOrder());

		System.out.println("\nAltura AVL: " + avl.height(avl.getRoot().data));
	}
	
	//====================================
	public void buscarDato(int x) {
		System.out.println("\n========== BUSQUEDA ==========");
		try {
			System.out.println("BST encontro: " + bst.search(x));
			
		} catch (Exception e) {
			System.out.println("BST no encontro: " + x);
		}

		
		try {
			System.out.println("AVL encontro: " + avl.search(x));

		} catch (Exception e) {
			System.out.println("AVL no encontro: " + x);
		}
	}
}
