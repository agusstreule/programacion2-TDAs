package tda;

public interface TDAGrafo {

	public void inicializar();
	
	//Inicializada y nodo no exista
	public void agregarNodo(int nodo);
	// Inicializada y que nodo exista
	public void eliminarNodo(int nodo);
	// Inicializada
	public TDAConjunto nodos();
	// Inicializado y existe origen y destino
	public void agregarArista(int origen, int destino, int peso);
	// Inicializado y que exista arista
	public void eliminarArista(int origen, int destino);
	// Inicializado y existe origen y destino
	public boolean existeArista(int origen, int destino);
	// Inicializado y existe arista
	public int peso(int origen, int destino);
}
