package untref.aydoo.procesadorestadistico;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void test() {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1, bicicleta.getId());
	}

}
