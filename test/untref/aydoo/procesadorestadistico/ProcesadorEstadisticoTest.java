package untref.aydoo.procesadorestadistico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import net.lingala.zip4j.exception.ZipException;

import org.junit.Assert;
import org.junit.Test;

public class ProcesadorEstadisticoTest {

	@Test
	public void getBicicletaUtilizadaMasVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMasVeces();

		Assert.assertEquals(1235, bicicleta.getId());
	}

	@Test
	public void getBicicletaUtilizadaMenosVecesDeberiaRetornarBicicletaCalculada()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();
		Bicicleta bicicleta = procesadorEstadistico
				.getBicicletaUtilizadaMenosVeces();

		Assert.assertEquals(1102, bicicleta.getId());
	}

	@Test
	public void getTiempoPromedioDeUsoDeberiaRetornarValorCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();
		double tiempoPromedioDeUso = procesadorEstadistico
				.getTiempoPromedioDeUso();

		Assert.assertEquals(28.2811, tiempoPromedioDeUso, 0.1);
	}

	@Test
	public void getRecorridoMasVecesRealizadoDeberiaRetornarRecorridoCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();
		Recorrido recorrido = procesadorEstadistico
				.getRecorridoMasVecesRealizado();

		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Assert.assertEquals(recorridoEsperado, recorrido);
	}

	@Test
	public void isDaemonDeberiaRetornarTrueSiEspecificadoEnLineaDeComandos() {

		String[] args = { "entradas", "--daemon", "--testing" };
		
		try {
			Main.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}



		Assert.assertTrue(Main.getProcesadorEstadistico().isDaemon());
	}

	@Test
	public void isDaemonDeberiaRetornarFalseSiNoEspecificadoEnLineaDeComandos() {

		String[] args = { "entradas", "--on-demand", "--testing" };

		try {
			Main.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}


		Assert.assertFalse(Main.getProcesadorEstadistico().isDaemon());
	}

	@Test
	public void getResultadoDeberiaRetornarResultadoCalculado()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();

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

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

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

	@Test
	public void exportarYMLDeberiaGenerarArchivoYML()
			throws FileNotFoundException, UnsupportedEncodingException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		Bicicleta bicicletaMasUsada = new Bicicleta(1235);
		Bicicleta bicicletaMenosUsada = new Bicicleta(1102);
		double tiempoPromedio = 28.2811;
		Recorrido recorridoEsperado = new Recorrido(8, 8, "PLAZA ITALIA",
				"PLAZA ITALIA");

		Resultado resultado = new Resultado(bicicletaMasUsada,
				bicicletaMenosUsada, tiempoPromedio, recorridoEsperado);

		String string = procesadorEstadistico.getYML(resultado);

		procesadorEstadistico.exportarYML(string,
				"exportarYMLDeberiaGenerarArchivoYML.yml");

		File archivo = new File("exportarYMLDeberiaGenerarArchivoYML.yml");

		Assert.assertTrue(archivo.isFile());
	}
	
	@Test
	public void getCantidadVecesBicicletaUtilizadaMasVeces()
			throws IOException, ParseException, ZipException {

		ProcesadorEstadistico procesadorEstadistico = new ProcesadorEstadistico(
				"entradas");

		procesadorEstadistico.procesarRegistrosOnDemand();
		Integer cantidadVeces = procesadorEstadistico
				.getTiempoUsoDeBiciMasUtilizada();

		Assert.assertEquals(Integer.valueOf(987), cantidadVeces);
	}
}
