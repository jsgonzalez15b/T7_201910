package model.util;

import static org.junit.Assert.assertEquals;

import com.sun.xml.internal.bind.v2.runtime.Location;

import model.data_structures.MaxColaPrioridad;
import model.vo.LocationVO;

public class PruebaColaPrioridad {

	private MaxColaPrioridad<LocationVO> cola1; 
	private MaxColaPrioridad<LocationVO> cola2; 
	private MaxColaPrioridad<LocationVO> cola3; 
	private LocationVO locacion1; 
	private LocationVO locacion2; 
	private LocationVO locacion3; 
	private LocationVO locacion4; 
	private LocationVO locacion5; 
	private LocationVO locacion6;	
	private LocationVO[] arreglo; 
	
	public void setUp() {
		
		cola1=new MaxColaPrioridad<LocationVO>();
		cola2=new MaxColaPrioridad<>(); 
		cola3=new MaxColaPrioridad<>();
		
		locacion1= new LocationVO(1,"a",3); 
		locacion2= new LocationVO(12, "b", 4); 
		locacion3= new LocationVO(1212, "c", 123);
		locacion4= new LocationVO(123, "d", 235);
		locacion5= new LocationVO(6542, "e", 64);
		locacion6= new LocationVO(1654, "f", 4);
		
		
		arreglo = new LocationVO[7];
		arreglo[1]=locacion1; 
		arreglo[2]=locacion2; 
		arreglo[3]=locacion3; 
		arreglo[4]=locacion4; 
		arreglo[5]=locacion5; 
		arreglo[6]=locacion6; 
	}
	
	public void testAgregarMaxCola() {
		 for (int i=0; i<arreglo.length;i++) {
			 cola1.agregar(arreglo[i]);
		 }
		 //Primer caso: Caso general. 
		 assertEquals("El primer elemento no es el esperado",123,cola1.primero.darElemento().darId());
		 assertEquals("El ultimo elemento de la lista no corresponde",1, cola1.ultimo.darElemento().darId());
		 LocationVO locacion7=new LocationVO(7654,"sg",250); 
		 //Caso en el que el a agregar tenga mayor prioridad que el primero
		 cola1.agregar(locacion7);
		 assertEquals("El primer elemento no corresponde",7654,cola1.primero.darElemento().darId());
		 LocationVO locacion8=new LocationVO(824,"sg",1);
		 // Caso en el que tiene menor prioridad que el ultimo de la lista
		 cola1.agregar(locacion8);
		 assertEquals("El ultimo en cola no es el esperado",824, cola1.ultimo.darElemento().darId());
		 LocationVO locacion9=new LocationVO(861,"sg",240);
		 //Caso: No tiene mayor prioridad que el primero ni menor prioridad que el ultimo. 
		 cola1.agregar(locacion9);
		 assertEquals("El elemento no esta ubicado correctamente", 861, cola1.primero.darSiguiente().darElemento().darId() );
		 
	}
	
}
