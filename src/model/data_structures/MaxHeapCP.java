package model.data_structures;
/**
 *Heap de prioridad siempre ordenado de mayor a menor
 */
public class MaxHeapCP <T extends Comparable<T>>
{
  //Atributos

	/**
	 * Nodo maximo de Heap, primer nodo
	 */
	public Nodo<T> maximo;
	
	/**
	 * numero de elementos en Heap
	 */
	public int cantidad;
	
  /**
	 * altura actual del Heap
	 */
	public int generacion;
  
	//Metodo Constructor
	public MaxHeapCP ()
	{
		//Inicializa el maximo nodo como vacio, y la cantidad y altura como 0.
		maximo= null;
		altura = 0;
		cantidad= 0;
	}
  
}
