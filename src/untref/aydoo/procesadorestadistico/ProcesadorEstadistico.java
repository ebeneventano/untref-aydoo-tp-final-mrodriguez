package untref.aydoo.procesadorestadistico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProcesadorEstadistico {

	private Map<Integer, Bicicleta> bicicletas;

	public ProcesadorEstadistico() {

		this.bicicletas = new HashMap<Integer, Bicicleta>();
	}

	public Bicicleta getBicicletaUtilizadaMasVeces() {

		Iterator<Bicicleta> iterador = this.bicicletas.values().iterator();

		Bicicleta bicicletaUtilizadaMasVeces = null;

		int vecesUtilizada = 0;
		int maximo = 0;

		while (iterador.hasNext()) {

			Bicicleta bicicleta = iterador.next();

			vecesUtilizada = bicicleta.getViajes().size();

			if (vecesUtilizada > maximo) {

				maximo = vecesUtilizada;
				bicicletaUtilizadaMasVeces = bicicleta;
			}
		}

		return bicicletaUtilizadaMasVeces;
	}

}
