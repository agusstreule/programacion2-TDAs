package implementations.dynamics;

import tda.TDAConjunto;
import tda.TDADiccionarioSimple;

public class DiccionarioSimple implements TDADiccionarioSimple {

	class NodoClave {
		int clave;
		int valor;
		NodoClave sig;
	}
	
	NodoClave origen;
	
	private NodoClave getNodoByClave(int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave)
			aux = aux.sig;
		return aux;
	}
	
	@Override
	public void agregar(int clave, int valor) {
		NodoClave nodo = getNodoByClave(clave);
		if (nodo == null) {
			nodo = new NodoClave();
			nodo.clave = clave;
			nodo.sig = origen;
			origen = nodo;
		}
		nodo.valor = valor;
	}

	@Override
	public void eliminar(int clave) {
		if (origen != null && origen.clave == clave)
			origen = origen.sig;
		else {
			NodoClave aux = origen;
			while (aux.sig != null && aux.sig.clave != clave)
				aux = aux.sig;
			if (aux.sig != null)
				aux.sig = aux.sig.sig;
		}
	}

	@Override
	public int recuperar(int clave) {
		NodoClave nodo = getNodoByClave(clave);
		return nodo.valor;
	}

	@Override
	public TDAConjunto claves() {
		TDAConjunto c = new Conjunto();
		c.inicializar();
		
		NodoClave aux = origen;
		while (aux != null) {
			c.agregar(aux.clave);
			aux = aux.sig;
		}
		
		return c;
	}

	@Override
	public void inicializar() {
		origen = null;
	}

}
