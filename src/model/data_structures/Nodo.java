package model.data_structures;

import model.data_structures.Nodo.Color;

/** Clase que permite el almacenamiento de objetos genéricos en colas y filas
 *  Implementa los métodos necesarios para ambas estructuras de datos ()
 */
public class Nodo<k extends Comparable<k>,T>
{
	public enum Color{
		ROJO,
		NEGRO
	}
	//Atributos

	/**
	 * objeto genérico almacenado por el nodo. 
	 */
	private T elemento;


	Color color; 
	/**
	 * Relación de cola/pila en lista simplemente encadenada
	 */
	private Nodo<k,T> izquierdo;

	/**
	 * Relación de cola/pila en lista doblemente encadenada
	 */
	private Nodo<k,T> derecho;

	private Nodo<k,T> padre; 

	private k llave; 
	private boolean rojo; 

	private boolean negro; 
	//Método Constructor
	public Nodo (k pllave, T pElemento, Color pColor)
	{
		izquierdo=null; 
		derecho=null; 
		rojo=true; 
		negro=false; 
		elemento=pElemento;
		llave=pllave; 
		color=pColor;
		padre=null; 
	}

	//Métodos del nodo

	public void setPadre(Nodo<k,T>pPadre) {
		padre=pPadre; 
	}
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

	public k darLlave() {
		return llave; 
	}
	public boolean esRojo() {
		return color==Color.ROJO?true:false; 
	}

	public void setColor(Color pcolor) {
		color=pcolor; 
	}

	public Nodo<k,T> darPadre(){
		return padre; 
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

	public Nodo<k,T> getNode(k key) {
		Nodo<k,T> buscado=null; 
		if(key.compareTo(this.llave)<0&&izquierdo!=null){
			buscado=izquierdo.getNode(key); 
		}
		else if(key.compareTo(this.llave)>0 && derecho!=null) {
			buscado= derecho.getNode(key);
		}else if(key.compareTo(this.llave)==0){
			buscado=this;  
		}
		return buscado; 
	}

	public void setElemento(T pElemento) {
		elemento=pElemento; 
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

	public k min() {
		if(izquierdo==null) {
			return this.llave; 
		}else {
			return izquierdo.min(); 
		}
	}

	public k max() {
		if(derecho==null) {
			return this.llave; 
		}else {
			return derecho.max(); 
		}
	}

	public void put (k key, T val) throws Exception {
		if(key==null||val==null) {
			throw new Exception("El valor de la llave o su valor relacioando no puede ser null");
		}
		if(contains(key)) {
			getNode(key).setElemento(val);
		}else {
			Nodo<k,T> agregar= new Nodo<>(key, val,Color.ROJO);
			if(agregar.darLlave().compareTo(this.llave)<0) {
				if(izquierdo==null) {
					setIzquierdo(agregar);
					agregar.setPadre(this);
					if(padre.esRojo()) {
						agregar.rotarDerecha();
					}
				}
			}else {
				if(derecho==null) {
					setDerecho(agregar);
					agregar.setPadre(this);

				}
			}
		}

	}

	public void rotarDerecha() {
		Nodo<k,T> padresum=padre.darPadre(); 
		padresum.setPadre(padre);
		padresum.setIzquierdo(padre.darDerecho());
		padre.setDerecho(padresum);
		padre.setPadre(padresum.darPadre());
		padresum.setColor(Color.NEGRO);
		padre.setColor(Color.ROJO);
		this.setColor(Color.NEGRO);
	}
	public void rotarIzquierda() {
		Nodo<k,T> padresum=padre.darPadre();
		padresum.setIzquierdo(this);
		this.setIzquierdo(padre);
		padre.setPadre(this);
		this.setPadre(padresum);
		this.setColor(Color.NEGRO);
		this.darIzquierdo().setColor(Color.ROJO);
	}


}



