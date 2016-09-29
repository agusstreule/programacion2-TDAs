package implementations.dynamics;

import tda.TDAConjunto;
import tda.TDADiccionarioMultiple;

public class DiccionarioMultiple implements TDADiccionarioMultiple {

	class NodoClave {
		int clave;
		NodoValor valores;
		NodoClave sig;
	}
	
	class NodoValor {
		int valor;
		NodoValor sig;
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
		// Si no existe la clave
		if (nodo == null) {
			NodoClave nuevaC = new NodoClave();
			NodoValor val = new NodoValor();
			val.valor = valor;
			nuevaC.clave = clave;
			nuevaC.sig = origen;
			origen = nuevaC;
			nuevaC.valores = val;
		} else {
			// Existe la clave y por lo menos tiene que tener un valor asociado (por definición).
			NodoValor auxValores = nodo.valores;
			// Me fijo si es igual al primer valor
			if (auxValores.valor != valor) {
				// Recorro todos los valores
				while (auxValores.sig != null && auxValores.sig.valor != valor)
					auxValores = auxValores.sig;
				//Si no encontre el valor lo agrego
				if (auxValores.sig == null) {
					NodoValor nuevoValor = new NodoValor();
					nuevoValor.valor = valor;
					auxValores.sig = nuevoValor;
				}
				
			}
		}
			
	}

	@Override
	public void eliminar(int clave) {
		if (origen != null) {
			
			if (origen.clave == clave)
				origen = origen.sig;
			else {
				NodoClave nc = origen;
				while (nc.sig != null && nc.sig.clave != clave)
					nc = nc.sig;
				if (nc.sig != null)
					nc.sig = nc.sig.sig;
			}	
		}
			
	}

	@Override
	public void eliminarValor(int clave, int valor) {
		NodoClave nc = getNodoByClave(clave);
		if (nc != null) {
			NodoValor nv = nc.valores;
			while (nv != null && nv.valor != valor)
				nv = nv.sig;
			if (nv != null)
				nv = nv.sig;
//			if (nv != null && nv.valor == valor)
//				nv = nv.sig;
//			else {
//				while (nv.sig != null && nv.sig.valor != valor)
//					nv = nv.sig;
//				if (nv != null)
//					nv = nv.sig;
//			}
			if (nc.valores == null)
				this.eliminar(clave);
		}
	}

	@Override
	public TDAConjunto recuperar(int clave) {
		TDAConjunto values = new Conjunto();
		values.inicializar();
		NodoClave nodo = this.getNodoByClave(clave);
		// The node exists.
		if (nodo != null) {
			NodoValor valores = nodo.valores;
			while (valores != null) {
				values.agregar(valores.valor);
				valores = valores.sig;
			}
		}
		return values;
	}

	@Override
	public TDAConjunto claves() {
		TDAConjunto keys = new Conjunto();
		keys.inicializar();
		NodoClave auxClave = origen;
		while (auxClave != null) {
			keys.agregar(auxClave.clave);
			auxClave = auxClave.sig;
		}
			
		return keys;
	}

	@Override
	public void inicializar() {
		origen = null;
	}

}
