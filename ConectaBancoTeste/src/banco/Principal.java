package banco;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {

		ConectaBancoTeste conexao = new ConectaBancoTeste();

		Connection conexaoRecebida = conexao.criarConexaoComBaseTeste();

		if (conexaoRecebida == null) {
			System.out.println("Falha! Não posso usar o objeto");
		} else {
			System.out.println("Conexao OK");
		}

	}

}


