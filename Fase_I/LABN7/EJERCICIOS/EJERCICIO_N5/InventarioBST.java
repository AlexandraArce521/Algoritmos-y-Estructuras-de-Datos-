package EJERCICIO_05;

import Exceptions.*;
import bstreelinklistinterfgeneric.*;

public class InventarioBST {
    private LinkedBST<Producto> bst;

    public InventarioBST() {
        this.bst = new LinkedBST<>();
    }

    public void insert(Producto p) throws ItemDuplicated {
        bst.insert(p);
    }

    public void searchRange(int min, int max) {
        System.out.println("Productos en rango [" + min + ", " + max + "]:");
        searchRangeRec(bst.getRoot(), min, max);
    }

    private void searchRangeRec(Node<Producto> n, int min, int max) {
        if (n == null) {
        	return;
        }
        int codigo = n.data.getCodigo();
        if (codigo > min) {
        	searchRangeRec(n.left, min, max);
        }
        
        if (codigo >= min && codigo <= max) {
        	System.out.println(n.data);
        }
        
        if (codigo < max) {
        	searchRangeRec(n.right, min, max);
        }
    }

    public int countLeaves() {
        return countLeavesRec(bst.getRoot());
    }

    private int countLeavesRec(Node<Producto> n) {
        if (n == null) {
        	return 0;
        }
        if (n.left == null && n.right == null) {
        	return 1;
        }
        return countLeavesRec(n.left) + countLeavesRec(n.right);
    }

    public void printDescending() {
        System.out.println("Productos en orden descendente:");
        printDescendingRec(bst.getRoot());
    }

    private void printDescendingRec(Node<Producto> n) {
        if (n == null) {
        	return;
        }
        printDescendingRec(n.right);
        System.out.println(n.data);
        printDescendingRec(n.left);
    }
}
