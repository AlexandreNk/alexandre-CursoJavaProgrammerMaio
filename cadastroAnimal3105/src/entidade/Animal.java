package entidade;

public abstract class Animal {

	private String nome;
	private String CAF ;//cpf do animal

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
	
}