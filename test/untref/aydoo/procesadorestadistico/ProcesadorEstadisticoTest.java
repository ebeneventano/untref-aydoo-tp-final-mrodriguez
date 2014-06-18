package untref.aydoo.procesadorestadistico;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicleta1() {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros();
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}

}
