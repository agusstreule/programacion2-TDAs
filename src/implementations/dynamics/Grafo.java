package implementations.dynamics;

import tda.TDAConjunto;
import tda.TDAGrafo;

public class Grafo implements TDAGrafo {
	
	class NodoGrafo{ 
		int nodo;
		NodoArista arista;
		NodoGrafo sigNodo;
	}
	class NodoArista{ 
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista; 
	}
	
	NodoGrafo origen;

	@Override
	public void inicializar() {
		origen = null;
	}

	@Override
	public void agregarNodo(int nodo) {
		// Al agregar se agrega al principio de la lista.
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = nodo;
		aux.arista = null;
		aux.sigNodo = origen;
		origen = aux;
	}

	@Override
	public void eliminarNodo(int v) {
		// Si es el priimer nodo lo vuelo
		if (origen != null && origen.nodo == v)
			origen = origen.sigNodo;
		// Voy a recorrer el nodo para eliminar aristas, y en caso de que el nodo no haya sido el primero tambien lo borro
		NodoGrafo auxNodoG = origen;
		while (auxNodoG != null) {
			// Elimino las aristas para el nodo actual
			this.eliminarAristaNodo(auxNodoG, v);
			if (auxNodoG.sigNodo != null && auxNodoG.sigNodo.nodo == v) {
				// Lo encontré
				auxNodoG.sigNodo = auxNodoG.sigNodo.sigNodo;
			}
			auxNodoG = auxNodoG.sigNodo;
		}

	}
	
	private void eliminarAristaNodo(NodoGrafo nodo, int v)	{
		NodoArista aux = nodo.arista;
		if (aux != null) {
			if (aux.nodoDestino.nodo == v)
				nodo.arista = aux.sigArista;
			else {
				while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
					aux = aux.sigArista;
				if (aux.sigArista != null) {
					//Lo encontré
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
			
		}
	}

	@Override
	public TDAConjunto nodos() {
		TDAConjunto nodos = new Conjunto();
		nodos.inicializar();
		NodoGrafo aux = origen;
		while (aux != null) {
			nodos.agregar(aux.nodo);
			aux = aux.sigNodo;
		}
			
		return nodos;
	}

	private NodoGrafo getNodoByValue(int v) {
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo !=v) {
			aux = aux.sigNodo;
		}
		return aux;
	}
	
	@Override
	public void agregarArista(int origen, int destino, int peso) {
		NodoGrafo o = getNodoByValue(origen);
		NodoGrafo d = getNodoByValue(destino);
		if (o != null && d != null) {
			NodoArista nArista = new NodoArista();
			nArista.etiqueta = peso;
			nArista.nodoDestino = d;
			nArista.sigArista = o.arista;
			o.arista  = nArista;
		}

	}

	@Override
	public void eliminarArista(int origen, int destino) {
		NodoGrafo o = getNodoByValue(origen);
		this.eliminarAristaNodo(o, destino);

	}
	
	private NodoArista getAristaByDestino(NodoGrafo nodo, int destino) {
		NodoArista auxA = nodo.arista;
		while (auxA != null && auxA.nodoDestino.nodo != destino)
			auxA = auxA.sigArista;
		return auxA;
	}

	@Override
	public boolean existeArista(int origen, int destino) {
		NodoGrafo o = getNodoByValue(origen);
		NodoArista a = getAristaByDestino(o, destino);
		return (a != null);
	}

	@Override
	public int peso(int origen, int destino) {
		NodoGrafo o = getNodoByValue(origen);
		NodoArista a = getAristaByDestino(o, destino);
		if (a != null)
			return a.etiqueta;
		else
			return 0;
	}

}
