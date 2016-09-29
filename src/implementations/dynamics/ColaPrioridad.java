package implementations.dynamics;

import tda.TDAColaPrioridad;

public class ColaPrioridad implements TDAColaPrioridad {

	class NodoPrioridad {
		
		int info;
		int prioridad;
		NodoPrioridad sig;
		
	}
	
	NodoPrioridad mayorPrioridad;
	
	@Override
	// No me gusta como quedó
	public void acolarPrioridad(int x, int prioridad) {

		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prioridad = prioridad;
		// Si la cola está vacia o el valor a ingresar es mas prioritario
		if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		} else {
			NodoPrioridad aux = mayorPrioridad;
			while (aux.sig != null && aux.sig.prioridad >= prioridad)
				aux = aux.sig;
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
		
	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
	}

	@Override
	public int primero() {
		return mayorPrioridad.info;
	}

	@Override
	public boolean colaVacia() {
		return (mayorPrioridad == null);
	}

	@Override
	public int prioridad() {
		return mayorPrioridad.prioridad;
	}

	@Override
	public void inicializar() {
		mayorPrioridad = null;
	}

}
