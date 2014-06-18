package untref.aydoo.procesadorestadistico;

import java.util.Date;

public class Registro {

	private int usuarioid;
	private int bicicletaid;
	private int origenestacionid;
	private int destinoestacionid;
	private Date origenfecha;
	private Date destinofecha;
	private int tiempouso;
	private String origennombre;
	private String destinonombre;

	public Registro(int usuarioid, int bicicletaid, int origenestacionid,
			int destinoestacionid, Date origenfecha, Date destinofecha,
			int tiempouso, String origennombre, String destinonombre) {

		this.usuarioid = usuarioid;
		this.bicicletaid = bicicletaid;
		this.origenestacionid = origenestacionid;
		this.destinoestacionid = destinoestacionid;
		this.origenfecha = origenfecha;
		this.destinofecha = destinofecha;
		this.tiempouso = tiempouso;
		this.origennombre = origennombre;
		this.destinonombre = destinonombre;
	}

	public int getBicicletaid() {
		return bicicletaid;
	}

	public int getOrigenestacionid() {
		return origenestacionid;
	}

	public int getDestinoestacionid() {
		return destinoestacionid;
	}

	public Date getOrigenfecha() {
		return origenfecha;
	}

	public Date getDestinofecha() {
		return destinofecha;
	}

	public int getTiempouso() {
		return tiempouso;
	}

	public String getOrigennombre() {
		return origennombre;
	}

	public String getDestinonombre() {
		return destinonombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bicicletaid;
		result = prime * result + destinoestacionid;
		result = prime * result
				+ ((destinofecha == null) ? 0 : destinofecha.hashCode());
		result = prime * result
				+ ((destinonombre == null) ? 0 : destinonombre.hashCode());
		result = prime * result + origenestacionid;
		result = prime * result
				+ ((origenfecha == null) ? 0 : origenfecha.hashCode());
		result = prime * result
				+ ((origennombre == null) ? 0 : origennombre.hashCode());
		result = prime * result + tiempouso;
		result = prime * result + usuarioid;
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
		Registro other = (Registro) obj;
		if (bicicletaid != other.bicicletaid)
			return false;
		if (destinoestacionid != other.destinoestacionid)
			return false;
		if (destinofecha == null) {
			if (other.destinofecha != null)
				return false;
		} else if (!destinofecha.equals(other.destinofecha))
			return false;
		if (destinonombre == null) {
			if (other.destinonombre != null)
				return false;
		} else if (!destinonombre.equals(other.destinonombre))
			return false;
		if (origenestacionid != other.origenestacionid)
			return false;
		if (origenfecha == null) {
			if (other.origenfecha != null)
				return false;
		} else if (!origenfecha.equals(other.origenfecha))
			return false;
		if (origennombre == null) {
			if (other.origennombre != null)
				return false;
		} else if (!origennombre.equals(other.origennombre))
			return false;
		if (tiempouso != other.tiempouso)
			return false;
		if (usuarioid != other.usuarioid)
			return false;
		return true;
	}

}
