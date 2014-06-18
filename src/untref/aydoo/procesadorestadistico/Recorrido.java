package untref.aydoo.procesadorestadistico;

import java.util.HashSet;
import java.util.Set;

public class Recorrido {

	private int origenestacionid;
	private int destinoestacionid;
	private String origennombre;
	private String destinonombre;

	public Recorrido(int origenestacionid, int destinoestacionid,
			String origennombre, String destinonombre) {

		this.origenestacionid = origenestacionid;
		this.destinoestacionid = destinoestacionid;
		this.origennombre = origennombre;
		this.destinonombre = destinonombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recorrido other = (Recorrido) obj;
		if (destinoestacionid != other.destinoestacionid)
			return false;
		if (destinonombre == null) {
			if (other.destinonombre != null)
				return false;
		} else if (!destinonombre.equals(other.destinonombre))
			return false;
		if (origenestacionid != other.origenestacionid)
			return false;
		if (origennombre == null) {
			if (other.origennombre != null)
				return false;
		} else if (!origennombre.equals(other.origennombre))
			return false;
		return true;
	}

}
