package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidade.Cobra;

public class DaoCobra {

	public boolean salvarCobra(Cobra cobra) {
		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_cobra (nome, caf, tipoveneno) values (?, ?, ?)"; // Base do comando
																									// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de conexão da
																			// classe Fabrica de conexão

			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																					// comando SQL que vai ser
																					// preparado

			preparaOcomandoSQL.setString(1, cobra.getNome());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, cobra.getCAF()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, cobra.getTipoVeneno()); // Colocar o valor no campo email

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("A cachorro foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar a cachorro!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBase != null) {
					connectionBase.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
											// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return salvamento;

	}

}
