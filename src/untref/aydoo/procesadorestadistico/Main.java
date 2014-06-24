package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;

import net.lingala.zip4j.exception.ZipException;

public class Main {

	private static boolean daemon, testing;
	private static ProcesadorEstadistico procesadorEstadistico;

	public static void main(String[] args) throws IOException, ParseException,
			ZipException, InterruptedException {

		String directorio = null;

		for (int i = 0; i < args.length; i++) {

			switch (i) {
			case 0:
				directorio = args[0];
			case 1:
				if (args[i] == "--daemon" || args[i] == "-d") {
					daemon = true;
				} else {
					daemon = false;
				}
			case 2:
				if ((args[i] == "--testing" || args[i] == "-t")) {
					testing = true;
				} else {
					testing = false;
				}
			}
		}

		procesadorEstadistico = new ProcesadorEstadistico(directorio);
		procesadorEstadistico.setDaemon(daemon);

		if (!testing) {
			if (daemon) {

				System.out.println("Iniciando daemon.");
				procesadorEstadistico.restartDaemon();

			} else {

				System.out.println("Iniciando on demand.");
				procesadorEstadistico.onDemand();
			}
		}
	}

	public static ProcesadorEstadistico getProcesadorEstadistico() {

		return procesadorEstadistico;
	}

}
