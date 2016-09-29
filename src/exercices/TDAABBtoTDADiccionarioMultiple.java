package exercices;

import implementations.dynamics.ABB;
import implementations.dynamics.Conjunto;
import implementations.dynamics.DiccionarioMultiple;
import tda.ABBTDA;
import tda.TDAConjunto;
import tda.TDADiccionarioMultiple;

public class TDAABBtoTDADiccionarioMultiple {

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
//		TDAConjunto c = new Conjunto();
//		c.inicializar();
//		System.out.println("Raiz: "+a.getRaiz());
//		getDescendant(a,c);
//		
//		while (!c.conjuntoVacio()) {
//			int element = c.elegir();
//			System.out.println(element);
//			c.sacar(element);
//		}
		TDADiccionarioMultiple dict = new DiccionarioMultiple();
		dict.inicializar();
		transform(a, dict);
		TDAConjunto claves = dict.claves();
		while (!claves.conjuntoVacio()) {
			int k = claves.elegir();
			System.out.println("------");
			System.out.println("Clave: "+k);
			System.out.println("------");
			TDAConjunto valores = dict.recuperar(k);
			while (!valores.conjuntoVacio()) {
				int v = valores.elegir();
				System.out.println(v);
				valores.sacar(v);
			}
			claves.sacar(k);
		}
		System.out.println(dict.toString());
	}
	
	private static void getDescendant(ABBTDA a, TDAConjunto c) {
		if (!a.arbolVacio()) {
//			System.out.println("Current: "+a.getRaiz());
			if (!a.hijoIzq().arbolVacio()) {
				c.agregar(a.hijoIzq().getRaiz());
				getDescendant(a.hijoIzq(), c);
			}
			if (!a.hijoDer().arbolVacio()) {
				c.agregar(a.hijoDer().getRaiz());
				getDescendant(a.hijoDer(), c);
			}
				
		}
	}
	
	private static void transform(ABBTDA tree, TDADiccionarioMultiple dict) {
		if (!tree.arbolVacio()) {
			// Check if it's leaf
			if (!tree.hijoDer().arbolVacio() || !tree.hijoIzq().arbolVacio()) {
				TDAConjunto c = new Conjunto();
				c.inicializar();
				getDescendant(tree,c);
				while (!c.conjuntoVacio()) {
					int element = c.elegir();
					dict.agregar(tree.getRaiz(), element);
					c.sacar(element);
				}
				if (!tree.hijoIzq().arbolVacio())
					transform(tree.hijoIzq(), dict);
				if (!tree.hijoDer().arbolVacio())
					transform(tree.hijoDer(), dict);
			}
			
		}
	}
	
}
