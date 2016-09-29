package exercices;

import implementations.dynamics.ABB;
import implementations.dynamics.DiccionarioMultiple;
import tda.ABBTDA;
import tda.TDAConjunto;
import tda.TDADiccionarioMultiple;

public class Algoritmo1Previo2016 {

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
		
		TDADiccionarioMultiple dm = new DiccionarioMultiple();
		dm.inicializar();
		dm.agregar(12, 3);
		dm.agregar(12, 21);
		dm.agregar(3, 2);
		dm.agregar(3, 5);
		dm.agregar(21, 17);
		dm.agregar(21, 26);
		
		System.out.println("Es valido: "+verify(a,dm));
	}
	
	private static boolean verify(ABBTDA a, TDADiccionarioMultiple dm) {
		if (a.arbolVacio() || a.hijoDer().arbolVacio() || a.hijoIzq().arbolVacio())
			return true;
		TDAConjunto valores = dm.recuperar(a.getRaiz());
		TDAConjunto valores2 = dm.recuperar(a.getRaiz());
		if (!(a.hijoDer().getRaiz() == mayor(valores)) || !(a.hijoIzq().getRaiz() == menor(valores2)))
			return false;
		return (verify(a.hijoDer(), dm) && verify(a.hijoIzq(), dm));
	}
	private static int mayor(TDAConjunto valores) {
		int mayor = -1;
		while (!valores.conjuntoVacio()) {
			int el = valores.elegir();
			mayor = Math.max(mayor, el);
			valores.sacar(el);
		}
		System.out.println("Mayor: "+mayor);
		return mayor;
	}
	private static int menor(TDAConjunto valores) {
		int menor = 99999;
		while (!valores.conjuntoVacio()) {
			int el = valores.elegir();
			menor = Math.min(menor, el);
			valores.sacar(el);
		}
		System.out.println("Menor: "+menor);
		return menor;
	}
	
}
