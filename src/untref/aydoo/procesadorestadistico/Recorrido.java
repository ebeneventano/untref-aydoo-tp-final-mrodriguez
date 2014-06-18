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

}
