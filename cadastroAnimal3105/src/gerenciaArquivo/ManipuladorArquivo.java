package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entidade.Cachorro;

public class ManipuladorArquivo {

	public void registrarCachorro (Cachorro cachorro) {
		
		String enderecoArquivo = "C:\\JavaImpacta\\alexandre-CursoJavaProgrammerMaio\\cadastroAnimal3105\\registroCachorros.txt";
		
		try {
			
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			
			bufferWriter.append("O nome do cachorro é: " + cachorro.getNome());
			bufferWriter.newLine();
			bufferWriter.append("O CAF do cachorro é: " + cachorro.getCAF());
			bufferWriter.newLine();
			bufferWriter.append("A cor do pelo é: "+ cachorro.getCorPelo());
			
			bufferWriter.close();
		
		} catch (Exception e) {
			System.out.println("Erro ao registrar o cachorro!!!");
		}
		
	}
}
