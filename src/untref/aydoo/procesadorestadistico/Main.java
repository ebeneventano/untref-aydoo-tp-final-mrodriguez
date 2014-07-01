package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;

import untref.aydoo.procesadorestadistico.ProcesadorEstadistico;

import net.lingala.zip4j.exception.ZipException;

public class Main {

	private static boolean daemon, testing;
	private static ProcesadorEstadistico procesadorEstadistico;
	static long time_start;
	static long time_end;

	public static void main(String[] args) throws IOException, ParseException,
			ZipException, InterruptedException {

		time_start = System.currentTimeMillis();
		String directorio = null;

		if (args.length == 0) {

			System.out
					.println("Uso: java -jar procesadorEstadistico.jar [directorio] [-d | --daemon]");
			return;
		}

		for (int i = 0; i < args.length; i++) {

			switch (i) {
			case 0:
				directorio = args[0];
			case 1:
				if (args[i].equals("--daemon") || args[i].equals("-d")) {
					daemon = true;
				} else {
					daemon = false;
				}
			case 2:
				if ((args[i].equals("--testing") || args[i].equals("-t"))) {
					testing = true;
				} else {
					testing = false;
				}
			}
		}

		procesadorEstadistico = new ProcesadorEstadistico(directorio);
		procesadorEstadistico.setDaemon(daemon);

		if (!testing) {
			if (daemon == true) {

				System.out.println("Iniciando daemon.");
				procesadorEstadistico.restartDaemon();

			} else {

				System.out.println("Iniciando on demand.");
				procesadorEstadistico.onDemand();
			}
		}
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
	}

	public static ProcesadorEstadistico getProcesadorEstadistico() {
		return procesadorEstadistico;
	}

}
