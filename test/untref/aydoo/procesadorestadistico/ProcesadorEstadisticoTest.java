package untref.aydoo.procesadorestadistico;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}

	@Test
	public void getBicicletaUtilizadaMenosVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMenosVeces();

		Assert.assertEquals(1102, bicicleta.getId());
	}

	@Test
	public void getTiempoPromedioDeUsoDeberiaRetornarValorCalculado()
			throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		double tiempoPromedioDeUso = procesadorEstadistico
				.getTiempoPromedioDeUso();

		Assert.assertEquals(28.28, tiempoPromedioDeUso, 0.1);
	}

	@Test
	public void getRecorridoMasVecesRealizadoDeberiaRetornarRecorridoCalculado()
			throws IOException, ParseException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		procesadorEstadistico.procesarRegistros("test.csv");
		Recorrido recorrido = procesadorEstadistico
				.getRecorridoMasVecesRealizado();

		System.out.println(recorrido.toString());

		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Assert.assertEquals(recorridoEsperado, recorrido);
	}

}
