package entidade;

public class Premium extends Correntista {

	private Double limiteCredito;

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	// Metodo para calcular a anuidade conforme o tipo
	@Override
	public Double CalcularAnuidade(int qtdeTransacao) {
		return qtdeTransacao * 0.7;
	}
}
