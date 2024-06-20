package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Cachorro;

public class DaoCachorro {

	public boolean salvarCachorro(Cachorro cachorro) {
		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_cachorro (nome, caf, corpelo, preco, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base do comando
																									// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de conexão da
																			// classe Fabrica de conexão

			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																					// comando SQL que vai ser
																					// preparado

			preparaOcomandoSQL.setString(1, cachorro.getNome());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, cachorro.getCAF()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(3, cachorro.getCorPelo()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(4, cachorro.getPreco().toString());
			preparaOcomandoSQL.setString(5, cachorro.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, cachorro.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7, cachorro.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, cachorro.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, cachorro.getEndereco().getUf());

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

	public List<Cachorro> retornaListaCachorros() {

		String comandoSqlBuscarCachorro = "select * from tb_cachorro";

		List<Cachorro> listaCachorro = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoTabelaCachorro = null;

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de conexão da
																			// classe Fabrica de conexão

			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlBuscarCachorro);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// preparado
			resultadoTabelaCachorro = preparaOcomandoSQL.executeQuery();

			while (resultadoTabelaCachorro.next()) {
				Cachorro cachorro = new Cachorro();

				cachorro.setNome(resultadoTabelaCachorro.getString("nome"));
				cachorro.setCAF(resultadoTabelaCachorro.getString("CAF"));
				cachorro.setCorPelo(resultadoTabelaCachorro.getString("corPelo"));
				cachorro.setPreco(Double.parseDouble(resultadoTabelaCachorro.getString("preco")));

				listaCachorro.add(cachorro);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Erro na lista de cachorro!!!");

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

		return listaCachorro;
	}

	public boolean deletarCachorro(String caf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_cachorro where caf = ?"; // Base do comando SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de
																					// conexão da class //
																					// Fabrica de conexã
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																							// comando SQL que vai ser
																							// prepara
			preparaOcomandoSQL.setString(1, caf);// Coloca o valor no campo cpf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Gerente Deletado");// Log

			deletar = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel deletar o animal!!!");

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

		return deletar;

	}
	
	public boolean alterarCachorro(Cachorro cachorro) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_cachorro SET nome = ?, corpelo = ? WHERE caf = ? "; // Base do comando
																									// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de
																								// conexão da classe																				// Fabrica de conexão
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o																			// comando SQL que vai se																			// preparado
			preparaOcomandoSQL.setString(1, cachorro.getNome());
			preparaOcomandoSQL.setString(2, cachorro.getCorPelo()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, cachorro.getCAF());// Coloca o valor no campo cpf
			 // Colocar o valor no campo nome
			

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("O cachorro foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar o animal!!!");

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
