package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProcesadorEstadistico {

	private ManejadorDeArchivos manejadorDeArchivos;
	private Set<Registro> registros;
	private Map<Integer, Bicicleta> bicicletas;
	private Map<String, Recorrido> recorridos;

	public ProcesadorEstadistico() {

		this.manejadorDeArchivos = new ManejadorDeArchivos();
		this.bicicletas = new HashMap<Integer, Bicicleta>();
		this.recorridos = new HashMap<String, Recorrido>();
	}

	public void procesarRegistros(String archivo) throws IOException,
			ParseException {

		this.registros = this.manejadorDeArchivos.cargarRegistros(archivo);

		Iterator<Registro> iterador = this.registros.iterator();

		while (iterador.hasNext()) {

			Registro registro = iterador.next();

			String key = registro.getOrigennombre() + " - "
					+ registro.getDestinonombre();
			Recorrido recorrido = this.recorridos.get(key);

			if (recorrido == null) {

				recorrido = new Recorrido(registro.getOrigenestacionid(),
						registro.getDestinoestacionid(),
						registro.getOrigennombre(), registro.getDestinonombre());
				this.recorridos.put(key, recorrido);
			}

			Viaje viaje = new Viaje(registro.getOrigenfecha(),
					registro.getDestinofecha(), registro.getTiempouso(),
					recorrido);

			Bicicleta bicicleta = this.bicicletas
					.get(registro.getBicicletaid());

			if (bicicleta == null) {

				bicicleta = new Bicicleta(registro.getBicicletaid());
				this.bicicletas.put(registro.getBicicletaid(), bicicleta);
			}

			bicicleta.getViajes().add(viaje);
		}
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

	public Bicicleta getBicicletaUtilizadaMenosVeces() {

		Iterator<Bicicleta> iterador = this.bicicletas.values().iterator();

		Bicicleta bicicletaUtilizadaMenosVeces = null;

		int vecesUtilizada = 0;
		int minimo = 0;

		if (iterador.hasNext()) {

			Bicicleta bicicleta = iterador.next();
			vecesUtilizada = bicicleta.getViajes().size();
			minimo = vecesUtilizada;
			bicicletaUtilizadaMenosVeces = bicicleta;
		}

		while (iterador.hasNext()) {

			Bicicleta bicicleta = iterador.next();

			vecesUtilizada = bicicleta.getViajes().size();

			if (vecesUtilizada < minimo) {

				minimo = vecesUtilizada;
				bicicletaUtilizadaMenosVeces = bicicleta;
			}
		}

		return bicicletaUtilizadaMenosVeces;
	}

}
