package implementations.dynamics;

import tda.TDAPila;

public class Pila implements TDAPila {

	Nodo primero;
	
	@Override
	public void inicializar() {
		primero = null;
	}

	@Override
	public void apilar(int x) {
		Nodo aux = new Nodo();
		aux.info = x;
		aux.sig = primero;
		primero = aux;
	}

	@Override
	public void desapilar() {
		primero = primero.sig;
	}

	@Override
	public int tope() {
		return primero.info;
	}

	@Override
	public boolean pilaVacia() {
		return (primero == null);
	}

}
