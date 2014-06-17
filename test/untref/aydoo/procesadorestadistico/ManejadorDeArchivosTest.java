package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;
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

}
