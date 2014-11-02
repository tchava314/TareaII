package Logic;

/**
 * 
 * @author Tobias Clase Arbol Binario de Busqueda
 */

public class ArbolBB {

	/**
	 * 
	 * @author Tobias Clase privada nodoArbol hijos izq y der, y un dato tipo
	 *         generico
	 */

	private class nodoArbol {
		private ArbolBB hd;
		private ArbolBB hi;
		private Comparacion dato;

		/**
		 * Constructor nodoArbol
		 */

		private nodoArbol() {
			hd = null;
			hi = null;
			dato = null;
		}
	}

	/**
	 * Creacion de la raiz del arbol
	 */
	public nodoArbol raiz;

	/**
	 * Contructor del ArbolBB
	 */

	@SuppressWarnings("unused")
	public ArbolBB() {
		nodoArbol raiz = new nodoArbol();
	}

	/**
	 * Arbol vacio o no
	 * 
	 * @return true o false
	 */
	public boolean esVacio() {
		return (raiz == null);
	}

	/**
	 * Insertar un dato tipo generico
	 * 
	 * @param a
	 */
	public void insertar(Comparacion a) {
		if (esVacio()) {
			nodoArbol nuevo = new nodoArbol();
			nuevo.dato = a;
			nuevo.hd = new ArbolBB();
			nuevo.hi = new ArbolBB();
			raiz = nuevo;
		} else {
			if (a.Comparar(raiz.dato) == 1) {
				(raiz.hd).insertar(a);
			}
			if (a.Comparar(raiz.dato) == -1) {
				(raiz.hi).insertar(a);
			}
		}
	}

	public void preOrder() {
		if (!esVacio()) {
			System.out.print(raiz.dato + ", ");
			raiz.hi.preOrder();
			raiz.hd.preOrder();
		}
	}

	public void inOrder() {
		if (!esVacio()) {
			raiz.hi.inOrder();
			System.out.print(raiz.dato + ", ");
			raiz.hd.inOrder();
		}
	}

	public void posOrder() {
		if (!esVacio()) {
			raiz.hd.posOrder();
			raiz.hi.posOrder();
			System.out.print(raiz.dato + ", ");

		}
	}

	public ArbolBB buscar(Comparacion a) {
		ArbolBB arbolito = null;
		if (!esVacio()) {
			if (a.Comparar(raiz.dato) == 0) {
				return this;
			} else {
				if (a.Comparar(raiz.dato) == -1) {
					arbolito = raiz.hi.buscar(a);
				} else {
					arbolito = raiz.hd.buscar(a);
				}
			}
		}
		return arbolito;
	}

	public boolean existe(Comparacion a) {
		if (!esVacio()) {
			if (a.Comparar(raiz.dato) == 0) {
				return true;
			} else {
				if (a.Comparar(raiz.dato) == -1) {
					raiz.hi.existe(a);
				} else {
					raiz.hd.existe(a);
				}
			}
		}
		return false;
	}

	public int cantidad() {
		if (esVacio()) {
			return 0;
		} else {
			return (1 + raiz.hd.cantidad() + raiz.hi.cantidad());
		}
	}

	public int altura() {
		if (esVacio()) {
			return 0;
		} else {
			return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
		}
	}

	public Comparacion buscarMin() {
		ArbolBB arbolActual = this;
		while (!arbolActual.raiz.hi.esVacio()) {
			arbolActual = arbolActual.raiz.hi;
		}
		Comparacion devuelvo = arbolActual.raiz.dato;
		arbolActual.raiz = null;
		return devuelvo;
	}

	public Comparacion buscarMan() {
		ArbolBB arbolActual = this;
		while (!arbolActual.raiz.hd.esVacio()) {
			arbolActual = arbolActual.raiz.hd;
		}
		Comparacion devuelvo = arbolActual.raiz.dato;
		arbolActual.raiz = null;
		return devuelvo;
	}

	public boolean esHoja() {
		boolean hoja = false;
		if ((raiz.hi).esVacio() && (raiz.hd).esVacio()) {
			hoja = true;
		}
		return hoja;
	}

	public void eliminar(Comparacion a) {
		ArbolBB paraEliminar = buscar(a);
		if (!paraEliminar.esVacio()) {
			if (paraEliminar.esHoja()) {
				paraEliminar.raiz = null;
			} else {
				if (!paraEliminar.raiz.hi.esVacio()
						&& !paraEliminar.raiz.hd.esVacio()) {
					paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin();
				} else {
					if (paraEliminar.raiz.hi.esVacio()) {
						paraEliminar.raiz = paraEliminar.raiz.hd.raiz;
					} else {
						paraEliminar.raiz = paraEliminar.raiz.hi.raiz;
					}
				}
			}
		}
	}
}