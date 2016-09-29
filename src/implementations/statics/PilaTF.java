package implementations.statics;

import tda.TDAPila;

public class PilaTF implements TDAPila {

	int a[];
	int indice;
	@Override
	public void inicializar() {
		a = new int[100];
		indice = 0;
	}

	@Override
	public void apilar(int x) {
		a[indice] = x;
		indice++;
	}

	@Override
	public void desapilar() {
		indice--;
	}

	@Override
	public int tope() {
		return a[indice-1];
	}

	@Override
	public boolean pilaVacia() {
		return (indice==0);
	}

}
