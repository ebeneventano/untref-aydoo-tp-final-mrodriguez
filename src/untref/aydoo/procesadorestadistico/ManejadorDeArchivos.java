package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import au.com.bytecode.opencsv.CSVReader;

public class ManejadorDeArchivos {

	private CSVReader reader;
	private SimpleDateFormat dateParser = new SimpleDateFormat(
			"yyyy-mm-dd hh:mm:ss");
	private File directorio;

	public Set<Registro> cargarRegistros(File directorio) throws ZipException,
			IOException, ParseException {

		this.directorio = directorio;

		File[] listaDeArchivos;
		Set<Registro> registros = new HashSet<Registro>();

		listaDeArchivos = directorio.listFiles();

		for (int i = 0; i < listaDeArchivos.length; i++) {

			if (listaDeArchivos[i].isFile()
					&& listaDeArchivos[i].getName().endsWith(".zip")) {

				this.descomprimirZIP(listaDeArchivos[i]);
			}
		}

		listaDeArchivos = directorio.listFiles();

		for (int i = 0; i < listaDeArchivos.length; i++) {

			if (listaDeArchivos[i].isFile()
					&& listaDeArchivos[i].getName().endsWith(".csv")) {

				registros.addAll(this.leerCSV(listaDeArchivos[i]));
			}
		}

		return registros;
	}

	private Set<Registro> leerCSV(File archivo) throws IOException,
			ParseException {

		Set<Registro> registros = new HashSet<Registro>();

		reader = new CSVReader(new FileReader(archivo), ';');

		reader.readNext(); // header

		String[] nextLine;

		while ((nextLine = reader.readNext()) != null && nextLine.length != 0) {

			int usuarioid = Integer.parseInt(nextLine[0]);
			int bicicletaid = Integer.parseInt(nextLine[1]);
			int origenestacionid = Integer.parseInt(nextLine[3]);
			int destinoestacionid = Integer.parseInt(nextLine[6]);

			Date origenfecha = dateParser.parse(nextLine[2]);
			Date destinofecha = dateParser.parse(nextLine[5]);

			int tiempouso;

			if (nextLine[8].length() > 0) {

				tiempouso = Integer.parseInt(nextLine[8]);

			} else {

				tiempouso = 0;
			}

			String origennombre = nextLine[4];
			String destinonombre = nextLine[7];

			Registro registro = new Registro(usuarioid, bicicletaid,
					origenestacionid, destinoestacionid, origenfecha,
					destinofecha, tiempouso, origennombre, destinonombre);

			registros.add(registro);
		}

		reader.close();

		return registros;
	}

	private void descomprimirZIP(File archivo) throws ZipException {

		ZipFile zipFile = new ZipFile(archivo);
		zipFile.extractAll(directorio.getPath());
	}

	public void exportarYML(String yml, String archivo)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter(archivo);
		writer.print(yml);
		writer.close();
	}

}
