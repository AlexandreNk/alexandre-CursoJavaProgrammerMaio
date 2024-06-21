package validacao;

public class EntidadeValidacao {

	public Integer validaPeso(String pesoString) {
		
		int pesoInt;
		try {
			pesoInt = Integer.parseInt(pesoString);
		} catch (Exception e) {
			return null;
		}
		
		return pesoInt;
	}
}
