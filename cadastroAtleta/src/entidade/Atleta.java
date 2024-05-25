package entidade;

public class Atleta {
	public String nomeAtleta; //Variável para armazenar o nome do atleta
	public int idade; //Variável para armazenar a idade do atleta
	public int qtdPartida;
	public Double salario;
	
	public Atleta(String nome) {
		super();
		this.nomeAtleta = nomeAtleta;	
	}
	
	public String getNome() {
		return nomeAtleta;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}
}


