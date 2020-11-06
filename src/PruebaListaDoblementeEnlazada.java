import java.util.InputMismatchException;
import java.util.Scanner;

class Nodo {
	
	private Nodo nodoAnterior;
	private Nodo nodoSiguiente;
	private int dato;

	public Nodo(int dato) {
		nodoAnterior = nodoSiguiente = null; // Opcional
		this.dato = dato;
	}

	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	@Override
	public String toString() {
		return "Nodo [dato=" + dato + "]";
	}
	
}

/*
 * OPERACIONES BASICAS
 *   1) Creacion
 *   2) Insercion
 *     2a)Al inicio
 *     2b)Al final
 *   3) Eliminacion
 *     3a)Al inicio
 *     3b)Al final
 * */

class ListaDoblementeEnlazada{
	
	private Nodo nodoInicio;
	private Nodo nodoFin;
	
	// 1) Creacion
	public ListaDoblementeEnlazada() {}
	
	public int getNumeroElementos() {
		int num = 0;
		for(Nodo tmp=nodoInicio; tmp!=null; tmp=tmp.getNodoSiguiente())
			num++;
		return num;
	}

	// 2a) Insertar/Agregar elemento al INICIO
	public boolean agregarInicio(int dato) {
		Nodo nuevo = new Nodo(dato);
		
		if(verificarListaVacia()) {
			nodoInicio = nodoFin = nuevo;
		}else {
			nuevo.setNodoSiguiente(nodoInicio);
			nodoFin.setNodoAnterior(nuevo);
			nodoInicio = nuevo;
		}
		return true;
	}
	
	// 2b) Insertar/Agregar elemento al FINAL
	public boolean agregarFin(int dato) {
		Nodo nuevo = new Nodo(dato);
		
		if(verificarListaVacia()) {
			nodoInicio = nodoFin = nuevo;
		}else {
			nodoFin.setNodoSiguiente(nuevo);
			nuevo.setNodoAnterior(nodoFin);
			nodoFin = nuevo;
		}
		return true;
	}

	public boolean verificarListaVacia() {
		return nodoInicio==null;
	}

	public boolean vaciar() {
	    nodoInicio = nodoFin = null;
		return true;
	}
	
	public void mostrarPrimero() {
		if(verificarListaVacia()) {
			System.out.println("No hay elementos");
		}else {
			System.out.println(nodoInicio);
		}
	}

	public void mostrarUltimo() {
		if(verificarListaVacia()) {
			System.out.println("No hay elementos");
		}else {
			System.out.println(nodoFin);
		}
	}
	
	public void verLista() {
		if(verificarListaVacia()) {
			System.out.println("No hay elementos");
		}else {
            Nodo nodoActual = nodoInicio;
			
			while(nodoActual != null) {
				System.out.print("<--["+nodoActual.getDato()+"]-->");
				nodoActual = nodoActual.getNodoSiguiente();
			}
		}
	}
	
	public void buscarElemento(int numero) {
		if(!verificarListaVacia()) {
			Nodo tmp = nodoInicio;
			boolean encontrado = false;
			
			while(tmp!=null) {
				if(tmp.getDato()==numero) {
					encontrado = true;
					break;
				}
				tmp = tmp.getNodoSiguiente();
			}
			
			if(encontrado) {
				System.out.println("Encontrado!");
			}else {
				System.out.println("No se ha encontrado");
			}
		}else {
			System.out.println("No hay elementos");
		}
	}
}
