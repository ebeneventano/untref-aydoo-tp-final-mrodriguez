package untref.aydoo.procesadorestadistico;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + destinoestacionid;
		result = prime * result
				+ ((destinonombre == null) ? 0 : destinonombre.hashCode());
		result = prime * result + origenestacionid;
		result = prime * result
				+ ((origennombre == null) ? 0 : origennombre.hashCode());
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

	public int getOrigenestacionid() {
		return origenestacionid;
	}

	public void setOrigenestacionid(int origenestacionid) {
		this.origenestacionid = origenestacionid;
	}

	public int getDestinoestacionid() {
		return destinoestacionid;
	}

	public void setDestinoestacionid(int destinoestacionid) {
		this.destinoestacionid = destinoestacionid;
	}

	public String getOrigennombre() {
		return origennombre;
	}

	public void setOrigennombre(String origennombre) {
		this.origennombre = origennombre;
	}

	public String getDestinonombre() {
		return destinonombre;
	}

	public void setDestinonombre(String destinonombre) {
		this.destinonombre = destinonombre;
	}

}
