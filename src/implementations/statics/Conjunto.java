package implementations.statics;

import tda.TDAConjunto;

public class Conjunto implements TDAConjunto {

	int indice;
	int elem[];
	
	@Override
	public void agregar(int x) {
		if (!this.pertenece(x)){
			elem[indice] = x;
			indice++;
		}
	}

	@Override
	public void sacar(int x) {
		for (int i=0; i<elem.length; i++) {
			if (elem[i] == x) {
				elem[i] = elem[indice-1];
				indice--;
				break;
			}
		}
	}

	@Override
	public int elegir() {
		if (!conjuntoVacio())
			return elem[indice-1];
		else
			return -1;
	}

	@Override
	public boolean pertenece(int x) {
		for (int i=0; i<elem.length; i++) {
			if (elem[i] == x) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean conjuntoVacio() {
		return (indice == 0);
	}

	@Override
	public void inicializar() {
		indice = 0;
		elem = new int[100];
	}

}
