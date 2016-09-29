package tda;

public interface TDAColaPrioridad {

	//Inicializado
	void acolarPrioridad(int x, int prioridad);
	//Inicializado y no vacía
	void desacolar();
	//Inicializado y no vacía
	int primero();
	//Inicializado
	boolean colaVacia();
	//Inicializado y no vacía
	int prioridad();
	void inicializar();
}
