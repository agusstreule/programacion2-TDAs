package tda;

public interface TDADiccionarioMultiple {

	//Inicializado
	void agregar(int clave, int valor);
	//Inicializado
	void eliminar(int clave);
	//Inicializado
	void eliminarValor(int clave, int valor);
	//Inicializado
	TDAConjunto recuperar(int clave);
	//Inicializado
	TDAConjunto claves();
	
	void inicializar();	
}
