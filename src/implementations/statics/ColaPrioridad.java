package implementations.statics;

import tda.TDAColaPrioridad;

public class ColaPrioridad implements TDAColaPrioridad {

	int elem[];
	int prior[];
	int indice;
	
	@Override
	public void acolarPrioridad(int x, int prioridad) {
		int i = indice;
		for(; i>0 && prior[i-1]>prioridad; i--) {
			prior[i] = prior[i-1];
			elem[i] = elem[i-1];
		}
		prior[i] = prioridad;
		elem[i] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		indice--;
	}

	@Override
	public int primero() {
		return elem[indice-1];
	}

	@Override
	public boolean colaVacia() {
		return (indice == 0);
	}

	@Override
	public int prioridad() {
		return prior[indice-1];
	}

	@Override
	public void inicializar() {
		elem = new int[100];
		prior = new int[100];
		indice = 0;
	}

}
