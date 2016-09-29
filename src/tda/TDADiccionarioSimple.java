package tda;

public interface TDADiccionarioSimple {
	
	//Inicializado
	void agregar(int clave, int valor);
	//Inicializado y la clave exista
	void eliminar(int clave);
	//Inicializado
	int recuperar(int clave);
	//Inicializado
	TDAConjunto claves();
	
	void inicializar();

}
