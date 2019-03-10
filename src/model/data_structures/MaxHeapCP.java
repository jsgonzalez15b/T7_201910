package model.data_structures;
import java.lang.*;
/**
 *Heap de prioridad siempre ordenado de mayor a menor, mediante una implementación de una arreglo variable generica.
 */
public class MaxHeapCP <T extends Comparable<T>>
{
  //Atributos

	/**
	 * Lista generica
	 */
	public ArregloDinamico<T> arreglo;
	
	/**
	 * numero de elementos en Heap
	 */
	public int cantidad;
	
 	/**
	 * altura actual del Heap
	 */
	public int altura;
  
	//Metodo Constructor
	public MaxHeapCP ()
	{
		//Inicializa el maximo nodo como vacio, y la cantidad y altura como 0.
		arreglo= new ArregloDinamico<T>();
		altura = 0;
		cantidad= 0;
	}
	//Metodos del Heap

	/**
	 * Retorna true si Heap esta vacio
	 * @return true si la Heap esta vacio, false de lo contrario
	 */
	public boolean isEmpty()
	{
		return arreglo==null;
	}
	
	/**
	 * Recalcula la altura actual del Heap cada vez que el metodo sea llamado
	 */
	public int recalcularAltura()
	{
		altura = (int) ((Math.log(arreglo.length+1) / Math.log(2))-1);
		return = altura;
	}
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size()
	{
		return arreglo.length;
	}
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public void agregar(T pElemento)
	{
		//se agrega el elemento al final del arreglo dinamico
		arreglo.agregar(pElemento);
		//este elemento es elevado hasta su posicion correcta
		float(pElemento);
		//se actualiza la cantidad de elementos en el arbol y su altura
		cantidad=arreglo.length;
		recalcularAltura();
	}
	
	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public T delMax()
	{
		//se cambia el primer por el ultimo termino y se elimina la ultima posicion
		T primeroProvisional= arreglo[0];
		arreglo[0]= arreglo.darUltimo();
		arreglo[arreglo.darTamano()]= primeroProvisional;
		maximoEliminado = arreglo.eliminar(primeroProvisional);
		
		
		swim(); //el antiguo menor elemento es hundido hasta su nueva posicion
		//se actualiza la cantidad de elementos en el arbol y su altura
		cantidad=arreglo.length;
		recalcularAltura();
		
		return maximoEliminado; //se retorna el elemento eliminado de la lista
	}
	
	/**
	 * 
	 */
	public void swim(T pElemento)
	{
		
		
		
	}

	/**
	 * 
	 */
	public void float()
	{

		
		

	}

	public Iterador<T> iterator() {
		return new Iterador<T>(primero);
	}

  
}
