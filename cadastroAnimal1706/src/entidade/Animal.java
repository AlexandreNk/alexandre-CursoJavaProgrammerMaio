package entidade;

public abstract class Animal {

	private String nome;
	private String CAF;// cpf do animal
	private double Preco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCAF() {
		return CAF;
	}

	public void setCAF(String cAF) {
		CAF = cAF;
	}

	public Double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	// método para calcular o preco do animal
	public double calcularPreco(int peso) {

		return peso * 100.0;

	}
}