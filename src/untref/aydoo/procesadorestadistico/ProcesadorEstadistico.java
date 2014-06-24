package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.Yaml;

import net.lingala.zip4j.exception.ZipException;

public class ProcesadorEstadistico {

	private boolean daemon;

	private String directorio;
	private String salida = "salida.yml";
	private ManejadorDeArchivos manejadorDeArchivos;
	private Set<Registro> registros;
	private Map<Integer, Bicicleta> bicicletas;
	private Map<String, Recorrido> recorridos;
	private Set<File> zipsYaProcesados;

	public ProcesadorEstadistico(String directorio) {

		this.directorio = directorio;
		this.manejadorDeArchivos = new ManejadorDeArchivos(directorio);
		this.bicicletas = new HashMap<Integer, Bicicleta>();
		this.recorridos = new HashMap<String, Recorrido>();
		this.zipsYaProcesados = new HashSet<File>();
	}

	public void setDaemon(boolean daemon) {

		this.daemon = daemon;
	}

	public boolean isDaemon() {

		return daemon;
	}

	public void procesarRegistrosOnDemand() throws IOException, ParseException,
			ZipException {

		this.registros = this.manejadorDeArchivos.cargarRegistros();

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

	public double getTiempoPromedioDeUso() {

		int sumador = 0;
		int contador = 0;

		Iterator<Bicicleta> iterador = this.bicicletas.values().iterator();

		while (iterador.hasNext()) {

			Bicicleta bicicleta = iterador.next();

			Iterator<Viaje> iteradorViajes = bicicleta.getViajes().iterator();

			while (iteradorViajes.hasNext()) {

				Viaje viaje = iteradorViajes.next();

				sumador += viaje.getTiempouso();
				contador++;
			}
		}

		return (double) sumador / contador;
	}

	public Recorrido getRecorridoMasVecesRealizado() {

		/*
		 * Creación de un mapa con la cantidad de veces que se realizó el
		 * recorrido.
		 */

		Map<Recorrido, Integer> mapaVecesRealizado = new HashMap<Recorrido, Integer>();

		// Asignación de cantidad de recorridos.

		Iterator<Bicicleta> iteradorBicicletas = this.bicicletas.values()
				.iterator();

		while (iteradorBicicletas.hasNext()) {

			Bicicleta bicicleta = iteradorBicicletas.next();

			Iterator<Viaje> iteradorViajes = bicicleta.getViajes().iterator();

			while (iteradorViajes.hasNext()) {

				Viaje viaje = iteradorViajes.next();

				if (mapaVecesRealizado.containsKey(viaje.getRecorrido())) {

					int vecesRealizado = mapaVecesRealizado.get(viaje
							.getRecorrido()) + 1;
					mapaVecesRealizado
							.put(viaje.getRecorrido(), vecesRealizado);

				} else {

					mapaVecesRealizado.put(viaje.getRecorrido(), 1);
				}
			}
		}

		/*
		 * Búsqueda del máximo.
		 */

		Recorrido recorridoMasVecesRealizado = null;

		int vecesRealizado = 0;
		int maximo = 0;

		Iterator<Recorrido> iteradorRecorrido = mapaVecesRealizado.keySet()
				.iterator();

		while (iteradorRecorrido.hasNext()) {

			Recorrido recorrido = iteradorRecorrido.next();

			vecesRealizado = mapaVecesRealizado.get(recorrido);

			if (vecesRealizado > maximo) {

				maximo = vecesRealizado;
				recorridoMasVecesRealizado = recorrido;
			}
		}

		return recorridoMasVecesRealizado;
	}

	public Resultado getResultado() {

		Bicicleta bicicletaUtilizadaMasVeces = this
				.getBicicletaUtilizadaMasVeces();
		Bicicleta bicicletaUtilizadaMenosVeces = this
				.getBicicletaUtilizadaMenosVeces();
		double tiempoPromedioDeUso = this.getTiempoPromedioDeUso();
		Recorrido recorridoMasVecesRealizado = this
				.getRecorridoMasVecesRealizado();

		Resultado resultado = new Resultado(bicicletaUtilizadaMasVeces,
				bicicletaUtilizadaMenosVeces, tiempoPromedioDeUso,
				recorridoMasVecesRealizado);

		return resultado;
	}

	public String getYML(Object obj) {

		Yaml yaml = new Yaml();
		String textoYML = yaml.dump(obj);

		return textoYML;
	}

	public void exportarYML(String yml, String archivo)
			throws FileNotFoundException, UnsupportedEncodingException {

		this.manejadorDeArchivos.exportarYML(yml, archivo);
	}

	public void procesarRegistrosComoDaemon() throws IOException,
			ParseException, ZipException {

		this.registros = new HashSet<Registro>();
		Set<File> listaDeZIPs = this.manejadorDeArchivos.listarZIPs();

		Iterator<File> iterador = listaDeZIPs.iterator();

		while (iterador.hasNext()) {

			File zipFile = iterador.next();

			if (!zipsYaProcesados.contains(zipFile)) {
				this.registros.addAll(this.manejadorDeArchivos
						.procesarZIP(zipFile));
				Resultado resultado = this.getResultado();
				String yml = this.getYML(resultado);
				String ymlFilePath = this.directorio
						+ "/"
						+ zipFile.getName().subSequence(0,
								zipFile.getName().length() - 4) + ".yml";
				this.exportarYML(yml, ymlFilePath);
				this.zipsYaProcesados.add(zipFile);
				this.clearData();
			}
		}
	}

	public void restartDaemon() throws InterruptedException, IOException,
			ParseException, ZipException {

		procesarRegistrosComoDaemon();

		// Espera 1 segundo.
		Thread.sleep(1000);

		restartDaemon();
	}

	private void clearData() {

		this.bicicletas.clear();
		this.recorridos.clear();
	}

	public void onDemand() throws IOException, ParseException, ZipException {

		this.procesarRegistrosOnDemand();
		Resultado resultado = this.getResultado();
		String yml = this.getYML(resultado);
		this.exportarYML(yml, directorio + "/" + this.salida);
	}

}
