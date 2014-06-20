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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bicicleta other = (Bicicleta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}

}
