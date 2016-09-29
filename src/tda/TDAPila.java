package tda;

public interface TDAPila {

	void inicializar();
	// Precondicion: pila inicializada
	void apilar(int x);
	// Precondicion: pila no vacia
	void desapilar();
	// Precondicion: pila no vacia
	int tope();
	// Precondicion: pila inicializada 
	boolean pilaVacia();
	
}
