package untref.aydoo.procesadorestadistico;

import java.util.HashSet;
import java.util.Set;

public class Bicicleta {

	private int id;
	private Set<Viaje> viajes;

	public Bicicleta(int id) {

		this.id = id;
		this.viajes = new HashSet<Viaje>();
	}

	public int getId() {

		return this.id;
	}

	public Set<Viaje> getViajes() {

		return this.viajes;
	}

}
