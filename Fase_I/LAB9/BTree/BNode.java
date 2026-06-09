package btree;
import java.util.ArrayList;

public class BNode<T> {
	private static int nextId = 1;
	protected ArrayList<T> keys;
	protected ArrayList<BNode<T>> childs;
	protected int count;
	protected int idNode;
	
	public BNode (int n) {
		this.idNode = nextId++;	
		
		this.keys = new ArrayList<T>(n);
		this.childs = new ArrayList<BNode<T>>(n);
		this.count = 0;
		
		for (int i = 0; i < n - 1; i++) {
	        this.keys.add(null);
	    }
	    for (int i = 0; i < n; i++) {
	        this.childs.add(null);
	    }
	}
	
	public boolean nodeFull (int maxKeys) {
		return this.count == maxKeys;
	}
	
	public boolean nodeEmpty() {
		return this.count == 0;
	}
	
	public boolean searchNode(T key, int[] pos) {
		pos[0] = 0;
		while (pos[0] < count && ((Comparable<T>) key).compareTo(keys.get(pos[0])) > 0) {
			pos[0]++;
			
		}
		if(pos[0] < count && ((Comparable<T>) key).compareTo(keys.get(pos[0])) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "BNode(" + idNode + ")";
	}
	
	public ArrayList<T> getKeys() {
	    return this.keys;
	}

	public ArrayList<BNode<T>> getChilds() {
	    return this.childs;
	}

	public int getCount() {
	    return this.count;
	}

	public int getIdNode() {
	    return this.idNode;
	}
}

