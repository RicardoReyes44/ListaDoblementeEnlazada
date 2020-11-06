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
