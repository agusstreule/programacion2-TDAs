package implementations.dynamics;

import tda.TDAConjunto;

public class Conjunto implements TDAConjunto {
	
	Nodo primero;

	@Override
	public void agregar(int x) {
		if (!this.pertenece(x)) {
			Nodo nuevo = new Nodo();
			nuevo.info = x;
			nuevo.sig = primero;
			primero = nuevo;
		}
		
	}

	@Override
	public void sacar(int x) {
		// Está vacio?
		if (primero != null)
			// Primer elemento de la lista??
			if (primero.info == x)
				primero = primero.sig;
			else {
				Nodo aux = primero;
				while (aux.sig != null && x != aux.sig.info)
					aux = aux.sig;
				if (aux.sig != null)
					aux.sig = aux.sig.sig;
			}
	}

	@Override
	public int elegir() {
		return primero.info;
	}

	@Override
	public boolean pertenece(int x) {
		Nodo aux = primero;
		while (aux != null && aux.info != x)
			aux = aux.sig;
		
		return (aux != null);
	}

	@Override
	public boolean conjuntoVacio() {
		return (primero == null);
	}

	@Override
	public void inicializar() {
		primero = null;
	}

}
