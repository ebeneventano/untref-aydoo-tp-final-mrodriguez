package untref.aydoo.procesadorestadistico;

import org.junit.Assert;
import org.junit.Test;

public class BicicletaTest {

	@Test
	public void getIdDeberiaRetornarIdSeteado() {

		int idEsperado = 123;

		Bicicleta bicicleta = new Bicicleta(idEsperado);

		int id = bicicleta.getId();

		Assert.assertEquals(idEsperado, id);
	}

}
