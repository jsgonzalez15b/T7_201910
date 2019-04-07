package model.data_structures;

/** Clase que permite el almacenamiento de objetos genéricos en colas y filas
 *  Implementa los métodos necesarios para ambas estructuras de datos ()
 */
public class Nodo<k extends Comparable<k>,T>
{
	//Atributos

	/**
	 * objeto genérico almacenado por el nodo. 
	 */
	private T elemento;

	/**
	 * Relación de cola/pila en lista simplemente encadenada
	 */
	private Nodo<k,T> izquierdo;
	
	/**
	 * Relación de cola/pila en lista doblemente encadenada
	 */
	private Nodo<k,T> derecho;
	
	private k llave; 
	private boolean rojo; 
	
	private boolean negro; 
	//Método Constructor
	public Nodo (k pllave, T pElemento)
	{
		izquierdo=null; 
		derecho=null; 
		rojo=true; 
		negro=false; 
		elemento=pElemento;
		llave=pllave; 
	}

	//Métodos del nodo

	/**
	 * método encargado de reasignar el nodo siguiente. 
	 */
	public void setIzquierdo(Nodo<k,T> pIzquierdo)
	{
		izquierdo =pIzquierdo;
	}
	
	/**
	 * método encargado de reasignar el nodo siguiente. 
	 */
	public void setDerecho(Nodo<k,T> pDerecho)
	{
		derecho=pDerecho;
	}
	
	/**
	 * método encargado de retornar el elemento almacenado en el nodo. 
	 */
	public T darElemento()
	{
		return elemento;
	}

	/**
	 * método que retorna el siguiente nodo. 
	 */
	public Nodo<k,T> darIzquierdo()
	{
		return izquierdo; 
	}
	
	/**
	 * método que retorna el nodo anterior. 
	 */
	public Nodo<k,T> darDerecho()
	{
		return derecho;
	}
	
	public void setRojo(boolean p) {
		rojo=p; 
	}
	public void seNegro(boolean p) {
		negro=p; 
	}
	
	public k darLlave() {
		return llave; 
	}
	
	public boolean esHoja() {
		return (izquierdo==null&&derecho==null)?true:false;
	}

	public int Height() {
		if(esHoja()) {
			return 1; 
		}else {
			int alturaizq=0; 
			int alturader=0; 
			if(izquierdo!=null) {
				alturaizq=izquierdo.Height(); 
			}
			if(derecho!=null) {
				alturader=derecho.Height(); 
			}
			if(alturaizq>alturader) {
				return 1+alturaizq; 
			}else {
				return 1+alturader; 
			}
		}
	}

	public T get(k key) {
		T buscado=null; 
		if(key.compareTo(this.llave)<0&&izquierdo!=null){
			buscado=izquierdo.get(key); 
		}
		else if(key.compareTo(this.llave)>0 && derecho!=null) {
			buscado= derecho.get(key);
		}else if(key.compareTo(this.llave)==0){
			buscado=this.darElemento();  
		}
		return buscado; 
	}
	
	public int getHeight(k key) {
		if(llave.compareTo(key)==0) {
			return 1; 
		}else {
			int alturaizq=0; 
			int alturader=0; 
			if(izquierdo!=null) {
				alturaizq=izquierdo.Height(); 
			}
			if(derecho!=null) {
				alturader=derecho.Height(); 
			}
			if(alturaizq>alturader) {
				return 1+alturaizq; 
			}else {
				return 1+alturader; 
			}
		}
	}
	
	public boolean contains(k key) {
		boolean esta=false; 
		if(key.compareTo(this.llave)<0&&izquierdo!=null) {
			esta=izquierdo.contains(key); 
		}
		else if(key.compareTo(this.llave)>0&&derecho!=null) {
			esta=derecho.contains(key); 
		}
		else if(key.compareTo(this.llave)==0) {
			esta=true; 
		}
		return esta; 
	}
}

	
	
