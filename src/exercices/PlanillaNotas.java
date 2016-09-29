package exercices;

import implementations.dynamics.Cola;
import implementations.dynamics.Conjunto;
import tda.TDACola;
import tda.TDAConjunto;

public class PlanillaNotas implements TDAPlanillaNotas {

	public class NodoAlumno {
		int libreta;
		NodoNota notas;
		NodoAlumno sigA;
	}
	
	public class NodoNota {
		int nota;
		NodoNota sigN;
	}
	
	static NodoAlumno origen;
	
	public void inicializar() {
		origen = null;
	}
	
	private static NodoAlumno getNodeByLibreta(int libreta) {
		NodoAlumno aux = origen;
		while (aux != null && aux.libreta != libreta) {
			aux = aux.sigA;
		}
		return aux;
	}

	public void agregar(int libreta, int nota) {
		NodoAlumno node = getNodeByLibreta(libreta);
		// already exists.
		if (node != null) {
			NodoNota newNota = new NodoNota();
			newNota.nota = nota;
			newNota.sigN = node.notas;
			node.notas = newNota;
		} else {
			// Does not exist, so we create it.
			NodoAlumno newAlumno = new NodoAlumno();
			newAlumno.libreta = libreta;
			NodoNota newNota = new NodoNota();
			newNota.nota = nota;
			// check if it should be the first one
			if (origen.libreta > libreta) {
				newAlumno.sigA = origen;
				origen = newAlumno;
			} else {
				// Is not the first one
				NodoAlumno aux = origen;
				while (aux.sigA != null && aux.sigA.libreta < libreta) {
					aux = aux.sigA;
				}
				newAlumno.sigA = aux.sigA;
				aux.sigA = newAlumno;
			}
		}
	}
	public void eliminar(int libreta) {
		if (origen.libreta == libreta)
			origen = origen.sigA;
		else {
			NodoAlumno aux = origen;
			while (aux.sigA != null && aux.sigA.libreta != libreta)
				aux = aux.sigA;
			if (aux.sigA.libreta == libreta) {
				aux.sigA = aux.sigA.sigA;
			}
		}

	}

	@Override
	public void eliminarNota(int libreta, int nota) {
		// We get the alumno
		NodoAlumno node = getNodeByLibreta(libreta);
		// Check if it's the first nota
		if (node.notas.nota == nota) {
			node.notas = node.notas.sigN;
		} else {
			// we have to look for it
			NodoNota auxN = node.notas;
			while (auxN.sigN != null && auxN.sigN.nota != nota)
				auxN = auxN.sigN;
			if (auxN.sigN != null) {
				auxN.sigN = auxN.sigN.sigN;
			}
		}
		// After the delete if there is no notas, then we delete the alumno too.
		if (node.notas == null) {
			eliminar(libreta);
		}

	}

	public TDAConjunto aprobados() {
		TDAConjunto aprobados = new Conjunto();
		aprobados.inicializar();
		NodoAlumno auxA = origen;
		while (auxA != null) {
			NodoNota auxN = auxA.notas;
			int count = 0;
			int sum = 0;
			while (auxN != null) {
				count++;
				sum += auxN.nota;
				auxN = auxN.sigN;
			}
			if (count > 2 && (sum/count > 7))
				aprobados.agregar(auxA.libreta);
		}
		return aprobados;
	}

	public TDACola notas(int libreta) {
		NodoAlumno nodo = getNodeByLibreta(libreta);
		TDACola notas = new Cola();
		NodoNota auxN = nodo.notas;
		while (auxN != null) {
			notas.acolar(auxN.nota);
			auxN = auxN.sigN;
		}
		return notas;
	}

	public boolean planillaVacia() {
		return (origen == null);
	}

}
