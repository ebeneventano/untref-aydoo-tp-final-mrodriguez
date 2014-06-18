package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicleta1235() throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}
	
	@Test
	public void getBicicletaUtilizadaMenosVecesDeberiaRetornarBicicleta1102() throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMenosVeces();

		Assert.assertEquals(1102, bicicleta.getId());
	}

}
