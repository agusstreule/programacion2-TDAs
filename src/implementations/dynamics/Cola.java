package implementations.dynamics;

import tda.TDACola;

public class Cola implements TDACola {

	// Primer elemento de la cola.
	Nodo primero;
	// Ultimo nodo (agregado) en la cola
	Nodo ultimo;
	@Override
	public void acolar(int x) {
		Nodo aux = new Nodo();
		aux.sig = null;
		aux.info = x;
		// Si la cola está vacia
		if (primero == null) {
			primero = aux;
			ultimo = primero;
		} else {
			ultimo.sig = aux;
		}
	}

	@Override
	public void desacolar() {
		primero = primero.sig;
		// Si la cola queda vacia
		if (primero == null)
			ultimo = null;
	}

	@Override
	public int primero() {
		return primero.info;
	}

	@Override
	public boolean colaVacia() {
		return (ultimo == null);
	}

	@Override
	public void inicializar() {
		primero = null;
		ultimo = null;
	}

}
