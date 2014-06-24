package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import net.lingala.zip4j.exception.ZipException;

public class Main {

	private static String directorio;
	private static boolean daemon;
	private static ProcesadorEstadistico procesadorEstadistico;
	private static String salida = "salida.yml";

	public static void main(String[] args) throws IOException, ParseException,
			ZipException {

		for (int i = 0; i < args.length; i++) {

			switch (i) {
			case 0:
				directorio = args[0];
			case 1:
				if (args[i] == "-d") {
					daemon = true;
				} else {
					daemon = false;
				}
			}
		}

		procesadorEstadistico = new ProcesadorEstadistico();

		if (!daemon) {

			procesadorEstadistico.procesarRegistros(new File(directorio));
			Resultado resultado = procesadorEstadistico.getResultado();
			String yml = procesadorEstadistico.getYML(resultado);
			procesadorEstadistico.exportarYML(yml, directorio + "/" + salida);

		} else {

			procesadorEstadistico.setDaemon(daemon);
		}
	}

	public static ProcesadorEstadistico getProcesadorEstadistico() {

		return procesadorEstadistico;
	}

}
