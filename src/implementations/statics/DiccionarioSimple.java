package implementations.statics;

import tda.TDAConjunto;
import tda.TDADiccionarioSimple;

public class DiccionarioSimple implements TDADiccionarioSimple {

	private int indice;
	private int claves[];
	private int valores[];
	
	@Override
	public void agregar(int clave, int valor) {
		for (int i = 0; i<claves.length; i ++) {
			if (clave == claves[i]) {
				valores[i] = valor;
				return;
			}
		}
		claves[indice] = clave;
		valores[indice] = valor;
		indice++;
	}

	@Override
	public void eliminar(int clave) {
		for (int i = 0; i<claves.length; i ++) {
			if (clave == claves[i]) {
				claves[i] = claves[indice-1];
				valores[i] = valores[indice-1];
				indice--;
				break;
			}
		}
	}

	@Override
	public int recuperar(int clave) {
		for (int i = 0; i<claves.length; i ++) {
			if (clave == claves[i])
				return valores[i];
		}
		return 0;
	}

	@Override
	public TDAConjunto claves() {
		TDAConjunto clav = new Conjunto();
		clav.inicializar();
		for (int i=0; i<indice; i ++) {
			clav.agregar(claves[i]);
		}
		return clav;
	}

	@Override
	public void inicializar() {
		this.indice = 0;
		this.claves = new int[100];
		this.valores = new int[100];
	}

}
