package exercices;

import implementations.dynamics.ABB;
import implementations.dynamics.DiccionarioSimple;
import implementations.dynamics.Grafo;
import tda.ABBTDA;
import tda.TDAConjunto;
import tda.TDADiccionarioSimple;
import tda.TDAGrafo;

public class ABBTDAtoTDAGrafo {

	public static void main(String[] args) {
		ABBTDA a = new ABB();
		a.inicializar();
		a.agregar(12);
		a.agregar(3);
		a.agregar(5);
		a.agregar(2);
		a.agregar(21);
		a.agregar(17);
		a.agregar(26);
		a.agregar(24);
		TDADiccionarioSimple ds = new DiccionarioSimple();
		getDescendant(a,a,ds);
		TDAGrafo grafo = buildGraph(a.getRaiz(), ds);
	}
	
	private static void getDescendant(ABBTDA a, ABBTDA root, TDADiccionarioSimple ds) {
		if (!root.arbolVacio()) {
			if (!root.hijoIzq().arbolVacio()) {
				ds.agregar(root.hijoIzq().getRaiz(), getDepth(a, root.hijoIzq().getRaiz()));
				getDescendant(a, root.hijoIzq(),ds);
			}
			if (!root.hijoDer().arbolVacio()) {
				ds.agregar(root.hijoDer().getRaiz(), getDepth(a, root.hijoDer().getRaiz()));
				getDescendant(a, root.hijoDer(), ds);
			}
				
		}
	}
	
	private static int getDepth(ABBTDA a, int node) {
		// We reach a leaf and is not the node we are looking for.
		if (a.arbolVacio() && a.getRaiz() != node)
			return -1;
		// We reach the node, stop the recursion.
		else if (a.getRaiz() == node)
			return 0;
		else {
			// We select wich children we get after.
			if (a.getRaiz() > node)
				return getDepth(a.hijoIzq(), node) +1;
			else
				return getDepth(a.hijoDer(), node) +1;
		}
		
			
	}
	private static TDAGrafo buildGraph(int origin, TDADiccionarioSimple ds) {
		TDAGrafo g = new Grafo();
		g.inicializar();
		g.agregarNodo(origin);
		TDAConjunto keys = ds.claves();
		while (!keys.conjuntoVacio()) {
			int el = keys.elegir();
			g.agregarNodo(el);
			g.agregarArista(origin, el, ds.recuperar(el));
		}
		
		return g;
	}
	
}
