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

		Assert.assertEquals(28.2811, tiempoPromedioDeUso, 0.1);
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

	@Test
	public void isDaemonDeberiaRetornarTrueSiEspecificadoEnLineaDeComandos() {

		String[] args = { "/", "-d" };

		ProcesadorEstadistico.main(args);

		Assert.assertTrue(ProcesadorEstadistico.isDaemon());
	}

	@Test
	public void isDaemonDeberiaRetornarFalseSiNoEspecificadoEnLineaDeComandos() {

		String[] args = { "/" };

		ProcesadorEstadistico.main(args);

		Assert.assertFalse(ProcesadorEstadistico.isDaemon());
	}

	@Test
	public void getResultadoDeberiaRetornarResultadoCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();
		File archivo = new File("test.zip");

		procesadorEstadistico.procesarRegistros(archivo);

		Bicicleta bicicletaMasUsada = new Bicicleta(1235);
		Bicicleta bicicletaMenosUsada = new Bicicleta(1102);
		double tiempoPromedio = 28.2811;
		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Resultado resultadoEsperado = new Resultado(bicicletaMasUsada,
				bicicletaMenosUsada, tiempoPromedio, recorridoEsperado);
		Resultado resultado = procesadorEstadistico.getResultado();

		Assert.assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void getYMLDeberiaRetornarStringCalculada() {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico();

		Bicicleta bicicletaMasUsada = new Bicicleta(1235);
		Bicicleta bicicletaMenosUsada = new Bicicleta(1102);
		double tiempoPromedio = 28.2811;
		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Resultado resultado = new Resultado(bicicletaMasUsada,
				bicicletaMenosUsada, tiempoPromedio, recorridoEsperado);

		String stringEsperada = "!!untref.aydoo.procesadorestadistico.Resultado\n"
				+ "bicicletaUtilizadaMasVeces:\n"
				+ "  id: 1235\n"
				+ "  viajes: !!set {}\n"
				+ "bicicletaUtilizadaMenosVeces:\n"
				+ "  id: 1102\n"
				+ "  viajes: !!set {}\n"
				+ "recorridoMasVecesRealizado: {destinoestacionid: 8, destinonombre: PLAZA ITALIA, origenestacionid: 8,\n"
				+ "  origennombre: PLAZA ITALIA}\n"
				+ "tiempoPromedioDeUso: 28.2811\n";
		String string = procesadorEstadistico.getYML(resultado);

		Assert.assertEquals(stringEsperada, string);
	}
}
