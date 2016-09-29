package tda;

public interface ABBTDA {

	// Inicializado y no vacio
	public int getRaiz();
	// Inicializado y no vacio
	public ABBTDA hijoIzq();
	// Inicializado y no vacio
	public ABBTDA hijoDer();
	// Inicializado
	public boolean arbolVacio();
	// Inicializado
	public void agregar(int x);
	// Inicializado
	public void eliminar(int x);
	
	public void inicializar();
	
}
