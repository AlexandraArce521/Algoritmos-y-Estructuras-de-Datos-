package AVLTREE;
import bstreelinklistinterfgeneric.*;
import Exceptions.*;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
	class NodeAVL extends Node<E> {
		protected int bf;
		
		public NodeAVL (E data) {
			super(data);
			this.bf = 0;
		}
		
		@Override
		public String toString() {
			return data + "(" + this.bf + ")";
		}
	}
	
	private boolean height;
	
	//==================================================
	@Override
	public void insert(E x) throws ItemDuplicated {
		this.height = false;
		this.root = insert (x, (NodeAVL) this.root);
	}
	
	private Node<E> insert(E x, NodeAVL node) throws ItemDuplicated {
	    NodeAVL fat = node;

	    if (node == null) {
	        this.height = true;
	        fat = new NodeAVL(x);

	    } else {
	        int resC = node.data.compareTo(x);

	        if (resC == 0) {
	            throw new ItemDuplicated(x + " ya se encuentra en el arbol...");
	        }

	        if (resC < 0) {
	            fat.right = insert(x, (NodeAVL) node.right);

	            if (this.height) {
	                switch (fat.bf) {
	                    case -1:
	                        fat.bf = 0;
	                        this.height = false;
	                        break;

	                    case 0:
	                        fat.bf = 1;
	                        this.height = true;
	                        break;

	                    case 1:
	                        fat = balanceToLeft(fat);
	                        this.height = false;
	                        break;
	                }
	            }

	        } else {
	            fat.left = insert(x, (NodeAVL) node.left);

	            if (this.height) {
	                switch (fat.bf) {
	                    case 1:
	                        fat.bf = 0;
	                        this.height = false;
	                        break;

	                    case 0:
	                        fat.bf = -1;
	                        this.height = true;
	                        break;

	                    case -1:
	                        fat = balanceToRight(fat);
	                        this.height = false;
	                        break;
	                }
	            }
	        }
	    }

	    return fat;
	}
	
	//==============================================
	private NodeAVL balanceToLeft(NodeAVL node) {
	    NodeAVL hijo = (NodeAVL) node.right;

	    switch (hijo.bf) {
	        case 1:
	            node.bf = 0;
	            hijo.bf = 0;
	            node = rotateSL(node);
	            break;

	        case -1:
	            NodeAVL nieto = (NodeAVL) hijo.left;
	            
	            switch (nieto.bf) {
	                case -1:
	                    node.bf = 0;
	                    hijo.bf = 1;
	                    break;

	                case 0:
	                    node.bf = 0;
	                    hijo.bf = 0;
	                    break;

	                case 1:
	                    node.bf = -1;
	                    hijo.bf = 0;
	                    break;
	            }
	            
	            nieto.bf = 0;
	            node.right = rotateSR(hijo);
	            node = rotateSL(node);
	            break;
	    }

	    return node;
	}

	//=====================================================
	private NodeAVL balanceToRight(NodeAVL node) {
	    NodeAVL hijo = (NodeAVL) node.left;

	    switch (hijo.bf) {
	        case -1:
	            node.bf = 0;
	            hijo.bf = 0;
	            node = rotateSR(node);
	            break;
	            
	        case 1:
	            NodeAVL nieto = (NodeAVL) hijo.right;

	            switch (nieto.bf) {
	                case -1:
	                    node.bf = 1;
	                    hijo.bf = 0;
	                    break;

	                case 0:
	                    node.bf = 0;
	                    hijo.bf = 0;
	                    break;

	                case 1:
	                    node.bf = 0;
	                    hijo.bf = -1;
	                    break;
	            }
	            
	            nieto.bf = 0;
	            node.left = rotateSL(hijo);
	            node = rotateSR(node);
	            break;
	    }

	    return node;
	}
	
	//=========================================================
	private NodeAVL rotateSR(NodeAVL node) {
	    NodeAVL p = (NodeAVL) node.left;
	    node.left = p.right;
	    p.right = node;
	    node = p;
	    return node;
	}

	//====================================================
	private NodeAVL rotateSL(NodeAVL node) {
	    NodeAVL p = (NodeAVL) node.right;
	    node.right = p.left;
	    p.left = node;
	    node = p;
	    return node;
	}
	
	//==========================================
	@Override
	public void delete(E x) throws ExceptionIsEmpty {
	    if (isEmpty()) {
	        throw new ExceptionIsEmpty();
	    }
	    
	    this.height = false;
	    this.root = deleteAVL((NodeAVL) this.root, x);
	}
	
	private NodeAVL deleteAVL(NodeAVL node, E x) {
	    if(node == null) {
	        return null;
	    }
	    
	    int cmp = x.compareTo(node.data);
	    
	    if(cmp > 0) {
	        node.right = deleteAVL((NodeAVL) node.right, x);
	        
	        if(this.height) {
	            switch(node.bf) {
	                case 1:
	                    node.bf = 0;
	                    break;

	                case 0:
	                    node.bf = -1;
	                    this.height = false;
	                    break;

	                case -1:
	                    node = balanceToRight(node);
	                    break;
	            }
	        }

	    } else if(cmp < 0) {
	        node.left = deleteAVL((NodeAVL) node.left, x);
	        
	        if(this.height) {
	            switch(node.bf) {
	                case -1:
	                    node.bf = 0;
	                    break;

	                case 0:
	                    node.bf = 1;
	                    this.height = false;
	                    break;

	                case 1:
	                    node = balanceToLeft(node);
	                    break;
	            }
	        }

	    } else {

	        if(node.left == null && node.right == null) {
	            this.height = true;
	            return null;
	        }
	        
	        if(node.left == null) {
	            this.height = true;	
	            return (NodeAVL) node.right;
	        }
	        
	        if(node.right == null) {
	            this.height = true;
	            return (NodeAVL) node.left;
	        }
	        
	        
	        NodeAVL sucesor = getMin((NodeAVL) node.right);
	        node.data = sucesor.data;
	        node.right = deleteAVL((NodeAVL) node.right, sucesor.data);

	        if(this.height) {
	            switch(node.bf) {
	                case 1:
	                    node.bf = 0;
	                    break;

	                case 0:
	                    node.bf = -1;
	                    this.height = false;
	                    break;

	                case -1:
	                    node = balanceToRight(node);
	                    break;
	            }
	        }
	    }

	    return node;
	}
	
	private NodeAVL getMin(NodeAVL node) {
	    while(node.left != null) {
	        node = (NodeAVL) node.left;
	    }

	    return node;
	}
	
	//======================
	public void recorridoPorAmplitudRecursivo() {
		if (this.root == null) {
			return;
		}
		
		int altura = height(this.root.data);
		
		for (int i = 0; i <= altura; i++) {
			imprimirNivel(this.root, i);
		}
		
		System.out.println();
	}
	
	private void imprimirNivel(Node<E> n, int nivel) {
		if (n == null) {
			return;
		}
		
		if (nivel == 0) {
			System.out.print(n.data + " ");
		} else {
			imprimirNivel(n.left, nivel - 1);
			imprimirNivel(n.right, nivel - 1);
		}
	}

	//========================================================
	public void recorridoPreOrden() {

	    recorridoPreOrdenRec(this.root);

	    System.out.println();
	}
	
	//========================================================
	private void recorridoPreOrdenRec(Node<E> nodo) {

	    if(nodo == null) {
	        return;
	    }

	    System.out.print(nodo.data + " ");
	    recorridoPreOrdenRec(nodo.left);
	    recorridoPreOrdenRec(nodo.right);
	}
	
}




