package entidade;

public class Cachorro extends Animal {

	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}

	public String corPelo;

	@Override // sobrescrever o metodo se for cachorro * 120
	public double calcularPreco(int peso) {

		return peso * 120.0;
	}
}
