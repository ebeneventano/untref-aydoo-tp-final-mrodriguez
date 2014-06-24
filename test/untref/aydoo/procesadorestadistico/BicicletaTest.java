package untref.aydoo.procesadorestadistico;

import org.junit.Assert;
import org.junit.Test;

public class BicicletaTest {

	@Test
	public void getIdDeberiaRetornarIdSeteado() {

		int id = 123;

		Bicicleta bicicleta = new Bicicleta(id);

		Assert.assertEquals(id, bicicleta.getId());
	}

}
