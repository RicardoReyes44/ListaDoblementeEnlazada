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
	
	// 3b) eliminar elemento al FINAL
		public Nodo eliminarInicio() {	
			if(verificarListaVacia()) {
				System.out.println("Sin elementos");
				return null;
			}else {
				Nodo tmp = nodoInicio;
				
				if(nodoInicio==nodoFin) {
					vaciar();
					return tmp;
				}else {
					nodoInicio = nodoInicio.getNodoSiguiente();
					nodoInicio.setNodoAnterior(null);
				}
				
				return tmp;
			}
		}
		
		// 3b) eliminar elemento al FINAL
		public Nodo eliminarFin() {
			if(verificarListaVacia()) {
				System.out.println("Sin elementos");
				return null;
			}else {
				Nodo tmp = nodoFin;
				
				if(nodoInicio==nodoFin) {
					vaciar();
					return tmp;
				}else {
					nodoFin = nodoFin.getNodoAnterior();
					nodoFin.setNodoSiguiente(null);
				}
				return tmp;
			}
		}
		
		public Nodo eliminarElementoEspecifico(int dato) {
			if(verificarListaVacia()) {
				System.out.println("Sin elementos");
				return null;
			}else {
				Nodo tmp = null;
				
				if(nodoInicio==nodoFin && nodoInicio.getDato()==dato && nodoFin.getDato()==dato) {
					tmp=nodoInicio;
					vaciar();
					return tmp;
				}else if(nodoInicio.getDato()==dato) {
					tmp=nodoInicio;
					nodoInicio=nodoInicio.getNodoSiguiente();
					nodoInicio.setNodoAnterior(null);
				}else if(nodoFin.getDato()==dato){
					tmp=nodoFin;
					nodoFin=nodoFin.getNodoAnterior();
					nodoFin.setNodoSiguiente(null);
				}else {
					Nodo adelante = nodoInicio;
					Nodo anterior = null;
					
					while(adelante!=null) {
						if(adelante.getDato()!=dato) {
							anterior=adelante;
							adelante=adelante.getNodoSiguiente();
						}else {
							break;
						}
					}
					
					if(adelante!=null) {
						tmp=anterior.getNodoSiguiente();
						adelante.getNodoSiguiente().setNodoAnterior(anterior);
						anterior.setNodoSiguiente(adelante.getNodoSiguiente());
					}
					
				}
				return tmp;
			}
		}
}


public class PruebaListaDoblementeEnlazada {
	
static Scanner entrada = new Scanner(System.in);
	
	
	public static byte ingresarDato() {
		while(true) {
			System.out.print("Introduce un dato: ");
			
			byte dato = entrada.nextByte();
			
			if(dato>-1) {
				return dato;
			}else {
				System.out.println("Error no puedes ingresar esa opcion, por favor vuelve a intentarlo");
			}
		}
	}
    
    
    public static byte agregar(byte limite) {
    	while(true) {
		    System.out.print("Introduce una posicion: ");
		
		    byte pos = entrada.nextByte();
		
		    if(pos>=0 && pos<limite) {
			    return pos;
		    }else {
			    System.out.println("Error no puedes ingresar esa posicion, por favor vuelve a intentarlo\n");
		    }
	    }
    }
	
	
	public static byte ingresarSubOpcion(int el) {

		while(true) {
			System.out.println("-----------------Sub opciones------------------");
			System.out.println("1) Inicio");
			System.out.println("2) Final");
			if(el==1) {
				System.out.println("3) Elemento especifico");
			}

			System.out.print("Introduce una opcion: ");
			
			byte opcion = entrada.nextByte();
			
			if(el==0 && opcion==1 || el==0 && opcion==2) {
				return opcion;
			}else if(el==1 && opcion==1 || el==1 && opcion==2 || el==1 && opcion==3) {
				return opcion;
			}else {
				System.out.println("Error no puedes ingresar esa opcion, por favor vuelve a intentarlo");
			}
		}
	}
	

	public static byte ingresarOpcion() {
		
		while(true) {
			System.out.println("-----------------Menu------------------");
			System.out.println("1) Agregar elemento");
			System.out.println("2) Eliminar elemento");
			System.out.println("3) Recorrer lista");
			System.out.println("4) Buscar elemento");
			System.out.println("5) Vaciar lista");
			System.out.println("6) Ver cantida de elementos");
			System.out.println("7) Ver primero");
			System.out.println("8) Ver ultimo");
			System.out.println("9) Salir");
			System.out.print("Introduce una opcion: ");
			
			byte opcion = entrada.nextByte();
			
			if(opcion>=1 && opcion<=9) {
				return opcion;
			}else {
				System.out.println("Error no puedes ingresar esa opcion, por favor vuelve a intentarlo");
			}
		}
	}

	public static void main(String[] args) {

		ListaDoblementeEnlazada le = new ListaDoblementeEnlazada();

		boolean candado = true;
		
		while(candado) {
			try {
				
				byte opcion = ingresarOpcion();
				byte subOpcion;

				switch(opcion) {

				case 1:
					
					subOpcion = ingresarSubOpcion(0);
					
					if(subOpcion==1) {
						System.out.println(le.agregarInicio(ingresarDato()));
					}else{
						System.out.println(le.agregarFin(ingresarDato()));
					}
					break;

				case 2:
					subOpcion = ingresarSubOpcion(1);

					if(subOpcion==1) {
						System.out.println(le.eliminarInicio());
					}else if(subOpcion==2) {
						System.out.println(le.eliminarFin());
					}else {
						if(le.getNumeroElementos()!=0) {
							System.out.println(le.eliminarElementoEspecifico(ingresarDato()));
						}else {
							System.out.println("No hay elementos");
						}
					}
					break;

				case 3:
					System.out.println();
					le.verLista();
					System.out.println();
					break;
				
				case 4:
					le.buscarElemento(ingresarDato());
					break;
				
				case 5:
					le.vaciar();
					System.out.println("Lista vaciada");
					break;
				
				case 6:
					System.out.println("Existen "+le.getNumeroElementos()+" elementos");
					break;
				
				case 7:
					le.mostrarPrimero();
					break;
				
				case 8:
					le.mostrarUltimo();
					break;

				case 9:
					candado = false;
					System.out.println("\nPrograma terminado    :)");
					break;

				default:
					System.out.println("\nNo existe esa opcion, por favor vuelve a intentarlo");
					break;
				
				}
				
			}catch(InputMismatchException error){
				System.out.println("Error en la entrada de datos<" + error + ">, por favor vuelve a intentarlo");
			    entrada.nextLine();
			}

			System.out.println();

		}
	}

}
