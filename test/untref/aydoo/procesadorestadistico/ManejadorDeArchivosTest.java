package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeArchivosTest {

	@Test
	public void cargarRegistrosDeberiaRetornar10000Registros()
			throws IOException, ParseException {

		ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
		String archivo = "test.csv";

		Set<Registro> registros = manejadorDeArchivos.cargarRegistros(archivo);

		Assert.assertTrue(10000 == registros.size());
	}

	@Test
	public void cararRegistrosDeberiaGenerarRegistroCorrectamente()
			throws IOException, ParseException {

		ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos();
		String archivo = "test.csv";
		SimpleDateFormat dateParser = new SimpleDateFormat(
				"yyyy-mm-dd hh:mm:ss");

		Set<Registro> registros = manejadorDeArchivos.cargarRegistros(archivo);

		Date origenfecha = dateParser.parse("2013-01-02 07:49:52.937");
		Date destinofecha = dateParser.parse("2013-01-02 08:11:36.67");
		Registro registro = new Registro(36680, 1524, 20, 32, origenfecha,
				destinofecha, 22, "ONCE", "PARQUE PATRICIOS ");

		Assert.assertTrue(registros.contains(registro));
	}

}
