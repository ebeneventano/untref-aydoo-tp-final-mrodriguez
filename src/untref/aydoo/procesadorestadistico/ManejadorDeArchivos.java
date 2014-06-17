package untref.aydoo.procesadorestadistico;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import au.com.bytecode.opencsv.CSVReader;

public class ManejadorDeArchivos {

	private CSVReader reader;
	private SimpleDateFormat dateParser = new SimpleDateFormat(
			"yyyy-mm-dd hh:mm:ss");

	public Set<Registro> cargarRegistros(String archivo) throws IOException,
			ParseException {

		Set<Registro> registros = new HashSet<Registro>();

		reader = new CSVReader(new FileReader(archivo), ';');

		String[] nextLine;

		// header
		reader.readNext();

		while ((nextLine = reader.readNext()) != null && nextLine.length != 0) {

			int usuarioid = Integer.parseInt(nextLine[0]);
			int bicicletaid = Integer.parseInt(nextLine[1]);
			int origenestacionid = Integer.parseInt(nextLine[3]);
			int destinoestacionid = Integer.parseInt(nextLine[6]);
			
			Date origenfecha = dateParser.parse(nextLine[2]);
			Date destinofecha = dateParser.parse(nextLine[5]);
			
			int tiempouso = Integer.parseInt(nextLine[8]);

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

}
