package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import net.lingala.zip4j.exception.ZipException;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();
		File archivo = new File("test.zip");

		procesadorEstadistico.procesarRegistros(archivo);
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}

	@Test
	public void getBicicletaUtilizadaMenosVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();
		File archivo = new File("test.zip");

		procesadorEstadistico.procesarRegistros(archivo);
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMenosVeces();

		Assert.assertEquals(1102, bicicleta.getId());
	}

	@Test
	public void getTiempoPromedioDeUsoDeberiaRetornarValorCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();
		File archivo = new File("test.zip");

		procesadorEstadistico.procesarRegistros(archivo);
		double tiempoPromedioDeUso = procesadorEstadistico
				.getTiempoPromedioDeUso();

		Assert.assertEquals(28.28, tiempoPromedioDeUso, 0.1);
	}

	@Test
	public void getRecorridoMasVecesRealizadoDeberiaRetornarRecorridoCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();
		File archivo = new File("test.zip");

		procesadorEstadistico.procesarRegistros(archivo);
		Recorrido recorrido = procesadorEstadistico
				.getRecorridoMasVecesRealizado();

		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Assert.assertEquals(recorridoEsperado, recorrido);
	}

}
