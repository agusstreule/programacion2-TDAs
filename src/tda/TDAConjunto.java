package tda;

public interface TDAConjunto {
	
	// Inicializado
	void agregar(int x);
	// Inicializado.
	void sacar(int x);
	// Inicializado y no vacío.
	int elegir();
	// Inicializado
	boolean pertenece(int x);
	// Inicializado
	boolean conjuntoVacio();
	
	void inicializar();
	
	
}
