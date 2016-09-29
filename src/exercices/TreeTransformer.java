package exercices;

import implementations.dynamics.ABB;
import implementations.dynamics.Conjunto;
import implementations.dynamics.DiccionarioMultiple;
import tda.ABBTDA;
import tda.TDAConjunto;
import tda.TDADiccionarioMultiple;

public class TreeTransformer {

	static public boolean pertenece(ABBTDA a, int x) {
		if (a.arbolVacio()) {
			return false;
		} else if (a.getRaiz() == x) {
			return true;
		} else if (a.getRaiz() > x) {
			return pertenece(a.hijoIzq(), x);
		} else {
			return pertenece(a.hijoDer(), x);
		}
	}
	
	static public boolean isLeaf(ABBTDA a, int x) {
		if (a.arbolVacio()) {
			return false;
		} else if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
			return true;
		} else if (a.getRaiz() > x) {
			return pertenece(a.hijoIzq(), x);
		} else {
			return pertenece(a.hijoDer(), x);
		}
	}
	
	static public int minor(ABBTDA a) {
		if (a.hijoDer().arbolVacio() && a.hijoIzq().arbolVacio())
			return a.getRaiz();
		else if (!a.hijoIzq().arbolVacio()) {
			int menor = minor(a.hijoIzq());
			return menor;
		}
		else
			return 1;
	}
	
	
	static public TDADiccionarioMultiple transform (ABBTDA a) {
		TDADiccionarioMultiple dm = new DiccionarioMultiple();
		dm.inicializar();
		
		if (!a.arbolVacio()) {
			
			System.out.println(a.getRaiz());
			
			// Es hoja
			if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
				System.out.println("Soy una hoja");
			} else {
				transform(a.hijoIzq());
				if (!a.hijoIzq().arbolVacio())
					dm.agregar(a.getRaiz(), a.hijoIzq().getRaiz());
				transform(a.hijoDer());
				if (!a.hijoDer().arbolVacio())
					dm.agregar(a.getRaiz(), a.hijoDer().getRaiz());
//				if (!a.hijoIzq().arbolVacio()) {
//					dm.agregar(a.getRaiz(), a.hijoIzq().getRaiz());
//					transform(a.hijoIzq());
//				} else if (!a.hijoDer().arbolVacio()) {
//					dm.agregar(a.getRaiz(), a.hijoDer().getRaiz());
//					transform(a.hijoDer());
//				}
					
			}
//				dm.agregar(a.getRaiz(), a.hijoIzq().getRaiz());
//				transform(a.hijoIzq());
//			}
//			if (!a.hijoDer().arbolVacio()) {
//				dm.agregar(a.getRaiz(), a.hijoDer().getRaiz());
//				transform(a.hijoDer());
//			}
		}
		
		return dm;
	}
	
	static public void preOrder(ABBTDA a){ 
		if (!a.arbolVacio()) {
			System.out.println(a.getRaiz());
			preOrder(a.hijoIzq());
			preOrder(a.hijoDer());
		}
	}
	
	public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        ABBTDA a = new ABB();
        a.inicializar();
        a.agregar(10);
        a.agregar(15);
        a.agregar(8);
        a.agregar(22);
        a.agregar(5);
        a.agregar(9);
        System.out.println("-----------");
        System.out.println(minor(a));
        System.out.println("-----------");
//        preOrder(a);
        
        
        
        
        System.out.println("-----------");
        
        TDADiccionarioMultiple dm = transform(a);
        TDAConjunto claves = dm.claves();
        int clave;
        while (claves != null) {
        	clave = claves.elegir();
        	claves.sacar(clave);
        	System.out.println(clave);
        }
        
    }
	
}
