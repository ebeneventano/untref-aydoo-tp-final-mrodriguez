package untref.aydoo.procesadorestadistico;

public class Resultado {

	private Bicicleta bicicletaUtilizadaMasVeces;
	private Bicicleta bicicletaUtilizadaMenosVeces;
	private double tiempoPromedioDeUso;
	private Recorrido recorridoMasVecesRealizado;

	public Resultado(Bicicleta bicicletaUtilizadaMasVeces,
			Bicicleta bicicletaUtilizadaMenosVeces, double tiempoPromedioDeUso,
			Recorrido recorridoMasVecesRealizado) {
		super();
		this.bicicletaUtilizadaMasVeces = bicicletaUtilizadaMasVeces;
		this.bicicletaUtilizadaMenosVeces = bicicletaUtilizadaMenosVeces;
		this.tiempoPromedioDeUso = tiempoPromedioDeUso;
		this.recorridoMasVecesRealizado = recorridoMasVecesRealizado;
	}

	public Bicicleta getBicicletaUtilizadaMasVeces() {
		return bicicletaUtilizadaMasVeces;
	}

	public void setBicicletaUtilizadaMasVeces(
			Bicicleta bicicletaUtilizadaMasVeces) {
		this.bicicletaUtilizadaMasVeces = bicicletaUtilizadaMasVeces;
	}

	public Bicicleta getBicicletaUtilizadaMenosVeces() {
		return bicicletaUtilizadaMenosVeces;
	}

	public void setBicicletaUtilizadaMenosVeces(
			Bicicleta bicicletaUtilizadaMenosVeces) {
		this.bicicletaUtilizadaMenosVeces = bicicletaUtilizadaMenosVeces;
	}

	public double getTiempoPromedioDeUso() {
		return tiempoPromedioDeUso;
	}

	public void setTiempoPromedioDeUso(double tiempoPromedioDeUso) {
		this.tiempoPromedioDeUso = tiempoPromedioDeUso;
	}

	public Recorrido getRecorridoMasVecesRealizado() {
		return recorridoMasVecesRealizado;
	}

	public void setRecorridoMasVecesRealizado(
			Recorrido recorridoMasVecesRealizado) {
		this.recorridoMasVecesRealizado = recorridoMasVecesRealizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((bicicletaUtilizadaMasVeces == null) ? 0
						: bicicletaUtilizadaMasVeces.hashCode());
		result = prime
				* result
				+ ((bicicletaUtilizadaMenosVeces == null) ? 0
						: bicicletaUtilizadaMenosVeces.hashCode());
		result = prime
				* result
				+ ((recorridoMasVecesRealizado == null) ? 0
						: recorridoMasVecesRealizado.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tiempoPromedioDeUso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (bicicletaUtilizadaMasVeces == null) {
			if (other.bicicletaUtilizadaMasVeces != null)
				return false;
		} else if (!bicicletaUtilizadaMasVeces
				.equals(other.bicicletaUtilizadaMasVeces))
			return false;
		if (bicicletaUtilizadaMenosVeces == null) {
			if (other.bicicletaUtilizadaMenosVeces != null)
				return false;
		} else if (!bicicletaUtilizadaMenosVeces
				.equals(other.bicicletaUtilizadaMenosVeces))
			return false;
		if (recorridoMasVecesRealizado == null) {
			if (other.recorridoMasVecesRealizado != null)
				return false;
		} else if (!recorridoMasVecesRealizado
				.equals(other.recorridoMasVecesRealizado))
			return false;
		if (Double.doubleToLongBits(tiempoPromedioDeUso) != Double
				.doubleToLongBits(other.tiempoPromedioDeUso))
			return false;
		return true;
	}

}
