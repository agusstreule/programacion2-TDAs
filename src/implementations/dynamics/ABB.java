package implementations.dynamics;

import tda.ABBTDA;

public class ABB implements ABBTDA {

	class NodoABB {
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB raiz;
	
	@Override
	public int getRaiz() {
		return raiz.info;
	}

	@Override
	public ABBTDA hijoIzq() {
		return raiz.hijoIzq;
	}

	@Override
	public ABBTDA hijoDer() {
		return raiz.hijoDer;
	}

	@Override
	public boolean arbolVacio() {
		return (raiz == null);
	}

	@Override
	public void agregar(int x) {
		if (raiz == null){
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.inicializar();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.inicializar();
		} else if (raiz.info > x)
			raiz.hijoIzq.agregar(x);
		else if (raiz.info < x)
			raiz.hijoDer.agregar(x);
	}

	@Override
	public void eliminar(int x) {
		if (raiz != null) {
			// Si es hoja
			if (raiz.info == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio())
				raiz = null;
			else if (raiz.info == x && !raiz.hijoIzq.arbolVacio()) {
				raiz.info = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.eliminar(raiz.info);
			} else if (raiz.info == x && raiz.hijoIzq.arbolVacio()) {
				raiz.info = this.menor(raiz.hijoDer);
				raiz.hijoDer.eliminar(raiz.info);
			} else if (x > raiz.info)
				raiz.hijoDer.eliminar(x);
			else
				raiz.hijoIzq.eliminar(x);
		}
	}
	
	private int mayor(ABBTDA a) {
		if (a.hijoDer().arbolVacio())
			return a.getRaiz();
		else
			return mayor(a.hijoDer());
	}
	
	private int menor(ABBTDA a) {
		if (a.hijoIzq().arbolVacio())
			return a.getRaiz();
		else
			return menor(a.hijoIzq());
	}

	@Override
	public void inicializar() {
		raiz = null;
	}

}
