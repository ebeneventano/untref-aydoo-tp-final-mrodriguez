package untref.aydoo.procesadorestadistico;

import java.util.Date;

public class Viaje {

	private Date origenfecha;
	private Date destinofecha;
	private int tiempouso;
	private Recorrido recorrido;

	public Viaje(Date origenfecha, Date destinofecha, int tiempouso,
			Recorrido recorrido) {

		this.origenfecha = origenfecha;
		this.destinofecha = destinofecha;
		this.tiempouso = tiempouso;
		this.recorrido = recorrido;
	}

	public int getTiempouso() {

		return this.tiempouso;
	}

	public Recorrido getRecorrido() {

		return this.recorrido;
	}

	public Date getOrigenfecha() {
		return origenfecha;
	}

	public void setOrigenfecha(Date origenfecha) {
		this.origenfecha = origenfecha;
	}

	public Date getDestinofecha() {
		return destinofecha;
	}

	public void setDestinofecha(Date destinofecha) {
		this.destinofecha = destinofecha;
	}

	public void setTiempouso(int tiempouso) {
		this.tiempouso = tiempouso;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

}
