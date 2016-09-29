package implementations.statics;

import tda.TDACola;

public class Cola implements TDACola {
	
	int a[];
	int indice;
	
	@Override
	public void acolar(int x) {
		for (int i=a.length; i > 0; i--	) {
			a[i] = a[i-1];
		}
		a[0] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		indice--;
	}

	@Override
	public int primero() {
		return a[indice-1];
	}

	@Override
	public boolean colaVacia() {
		return (indice == 0);
	}

	@Override
	public void inicializar() {
		a = new int[100];

	}

}
