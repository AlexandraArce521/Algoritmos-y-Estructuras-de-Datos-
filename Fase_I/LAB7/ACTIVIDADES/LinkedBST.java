package bstreelinklistinterfgeneric;
import Exceptions.*;
import bstreeInterface.*;

public class LinkedBST<T extends Comparable<T>> implements BinarySearchTree<T> {
	private Node<T> root;
	
	public LinkedBST() {
		this.root = null;
	}
	
	public Node<T> getRoot(){
		return this.root;
	}
	//========================================================
	public T search(T d) throws ItemNoFound {
		Node<T> resultado = searchRec(this.root, d);
		
		if (resultado == null) {
			throw new ItemNoFound();
		}
		
		return resultado.data;
	}
	
	public Node<T> searchRec(Node<T> n, T d) {
		if (n == null) {
			return null;
		}
		
		int cmp = d.compareTo(n.data);
		
		if(cmp > 0) {
			return searchRec(n.right, d);
			
		}else if(cmp < 0) {
			return searchRec(n.left, d);
			
		} else {
			return n;
		}
	}
	//==========================================================
	public void insert(T d) throws ItemDuplicated {
		this.root = insertRec(this.root, d);
	}
	
	public Node<T> insertRec(Node<T> n, T d) throws ItemDuplicated {
		if (n == null) {
			return new Node<>(d);
		}
		
		int cmp = d.compareTo(n.data);
		
		if (cmp < 0) {
			n.left = insertRec(n.left, d);
			
		} else if(cmp > 0) { 
			n.right = insertRec(n.right, d);
			
		} else {
			throw new ItemDuplicated();
		}
	
		return n;
	}
	//================================================================
	public void delete(T d) throws ExceptionIsEmpty {
		if(isEmpty())
			throw new ExceptionIsEmpty();
		
		root = deleteRec(root, d);
	}
	
	public Node<T> deleteRec(Node<T> n, T d){
		if (n == null) {
			return null;
		}
		
		int cmp = d.compareTo(n.data);
		
		if(cmp > 0) {
			n.right = deleteRec(n.right, d);
			
		} else if(cmp < 0) {
			n.left = deleteRec(n.left, d);
			
		} else {
			if(n.left == null) {
				return n.right;
				
			} else if(n.right == null) {
				return n.left;
				
			} else {
				try {
					T minimo = findMinNode(n.right);
					n.data = minimo;
					n.right = deleteRec(n.right, minimo);
				} catch (ItemNoFound e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		return n;
	}
	//===============================================================
	public boolean isEmpty() {
		return this.root == null;
	}
	//=========================================================
	@Override
	public String toString() {
		return inOrder(this.root);
	}
	//=======================================================
	public String getInOrder() {
		return inOrder(this.root);
	}
	
	private String inOrder(Node<T> n) {
		if(n == null) {
			return "";
		}

		return inOrder(n.left) + n.data + " " + inOrder(n.right);
	}
	//==============================================
	public String getPreOrder() {
		return preOrder(this.root);
	}
	
	private String preOrder(Node<T> n) {
		if(n == null) {
			return "";
		}

		return n.data + " " + preOrder(n.left) + preOrder(n.right);
	}
	//===============================================
	public String getPostOrder() {
		return postOrder(this.root);
	}
	
	private String postOrder(Node<T> n) {
		if(n == null) {
			return "";
		}

		return postOrder(n.left) + postOrder(n.right) + n.data + " ";
	}
	//=================================================
	private T findMinNode(Node<T> node) throws ItemNoFound {
		if(node == null) {
			throw new ItemNoFound ("No se encuentra el valor minimo");
		}
		
		Node<T> actual = node;
		while(actual.left != null) {
			actual = actual.left;
		}
		return search(actual.data);
	}
	//================================================
	private T findMaxNode(Node<T> node) throws ItemNoFound {
		if(node == null) {
			throw new ItemNoFound ("No se encuentra el valor maximo");
		}
		
		Node<T> actual = node;
		while(actual.right != null) {
			actual = actual.right;
		}
		
		return search(actual.data);
	}
	
}
