package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicleta1() throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}

}
