package exercices;

import tda.TDACola;
import tda.TDAConjunto;

public interface TDAPlanillaNotas {
	
	void inicializar();
	//Inicializada
	void agregar(int libreta, int nota);
	// Inicializada
	void eliminar(int libreta);
	// Inicializada
	void eliminarNota(int libreta, int nota);
	// Inicializada
	TDAConjunto aprobados();
	// Inicializado
	TDACola notas(int libreta);
	// Inicializado
	boolean planillaVacia();

}
