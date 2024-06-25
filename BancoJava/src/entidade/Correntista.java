package entidade;

public class Correntista {
	private String nome;
	private String cpf;
	private String tipoCliente;
	private Endereco endereco;
	private int qtdeTransacao;
	private Double valorDaAnuidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getQtdeTransacao() {
		return qtdeTransacao;
	}

	public void setQtdeTransacao(int qtdeTransacao) {
		this.qtdeTransacao = qtdeTransacao;
	}

	public Double getValorDaAnuidade() {
		return valorDaAnuidade;
	}

	public void setValorDaAnuidade(Double valorDaAnuidade) {
		this.valorDaAnuidade = valorDaAnuidade;
	}

	// Metodo para calcular a anuidade conforme o tipo
	public Double CalcularAnuidade(int qtdeTransacao) {
		return qtdeTransacao * 0.5;
	}

}
