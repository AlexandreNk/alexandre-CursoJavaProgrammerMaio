package validacao;

public class EntidadeValidacao {
	
	public Integer validaqtdetransacao(String qtdeTranscaoString) {
		
		int qtdeTransacao;
		try {
			qtdeTransacao = Integer.parseInt(qtdeTranscaoString);
		} catch (Exception e) {
			return null;
		}
		
		return qtdeTransacao;
	}
}
