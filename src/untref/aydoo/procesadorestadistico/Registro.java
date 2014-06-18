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

}
