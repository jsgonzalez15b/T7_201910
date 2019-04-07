package model.data_structures;

public class RedBlackBST <k extends Comparable<k>,T>{

	private Nodo<k,T> raiz; 
	
	private int elementos;
	
	public RedBlackBST(){
		raiz=null; 
		elementos=0; 
	}
	
	public int size() {
		return elementos; 
	}
	
	public boolean isEmpty() {
		return raiz==null?true:false; 
	}
	
	public T get(k key) {
		T buscado=null; 
		if(!isEmpty()) {
			buscado=raiz.get(key);
		}
		return buscado; 
	}
	
	public int getHeight(k key) {
		if(isEmpty()||!contains(key)) {
			return -1; 
		}else {
			return raiz.getHeight();
		}
	}
	
	public int Height() {
		if(isEmpty()) {
			return 0; 
		}else {
			return raiz.Height();
		}
	}
	
	public boolean contains(k key) {
		if(!isEmpty()) {
			return raiz.contains(key); 
		}
		else {
			return false; 
		}
	}
}
