package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Set;

import net.lingala.zip4j.exception.ZipException;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeArchivosTest {

	@Test
	public void cargarRegistrosDeberiaRetornar10000Registros()
			throws IOException, ParseException, ZipException {

		ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos(
				"entradas");

		Set<Registro> registros = manejadorDeArchivos.cargarRegistros();

		Assert.assertEquals(10000, registros.size());
	}

	@Test
	public void cargarRegistrosDeberiaGenerarRegistroCorrectamente()
			throws IOException, ParseException, ZipException {

		ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos(
				"entradas");
//		SimpleDateFormat dateParser = new SimpleDateFormat(
//				"yyyy-mm-dd hh:mm:ss");

		Set<Registro> registros = manejadorDeArchivos.cargarRegistros();

//		Date origenfecha = dateParser.parse("2013-01-02 07:49:52.937");
//		Date destinofecha = dateParser.parse("2013-01-02 08:11:36.67");
		Registro registro = new Registro(36680, 1524, 20, 32, 22, "ONCE", "PARQUE PATRICIOS ");

		Assert.assertTrue(registros.contains(registro));
	}

	@Test
	public void listarZIPsDeberiaRetornarSetDeSize1() {

		ManejadorDeArchivos manejadorDeArchivos = new ManejadorDeArchivos(
				"entradas");

		Set<File> zips = manejadorDeArchivos.listarZIPs();

		Assert.assertEquals(1, zips.size());
	}

}
