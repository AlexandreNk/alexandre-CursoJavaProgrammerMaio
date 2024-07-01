package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;
import entidade.Premium;

public class DaoPremium {

	public boolean salvarPremium(Premium premium) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		// String comandoSqlInsert = "insert into tb_correntista_premium (cpf, nome,
		// tipocliente, valoranuidade, limitecredito, limitesaque, cep,
		// localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?,?,?)"; // Base
		String comandoSqlInsert = "insert into tb_correntista_premium (cpf, nome, valoranuidade, limitecredito, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base
		// do
		// comando
		// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da classe
																					// Fabrica de conexão

			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o
																					// comando SQL que vai ser
																					// preparado

			preparaOcomandoSQL.setString(1, premium.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, premium.getNome()); // Colocar o valor no campo nome
			// preparaOcomandoSQL.setString(3, premium.getTipoCliente());
			preparaOcomandoSQL.setString(3, premium.getValorDaAnuidade().toString());
			preparaOcomandoSQL.setString(4, premium.getLimiteCredito().toString());
			preparaOcomandoSQL.setString(5, premium.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, premium.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7, premium.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, premium.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, premium.getEndereco().getUf());

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("O correntista premium foi registrada");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar o correntista premium!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBase != null) {
					connectionBase.close();// Se objeto connectionBase estiver aberto essa linha vai
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

	public List<Premium> retornaListaDePremiums() {

		String comandoSqlBuscarPremium = "select * from tb_correntista_premium";
		List<Premium> listaPremium = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da classe
																					// Fabrica de conexão
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlBuscarPremium);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				Premium premium = new Premium();
				Endereco endereco = new Endereco();

				premium.setEndereco(endereco);

				premium.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				premium.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				premium.setLimiteCredito(Double.parseDouble(resultadoDaTabelaDoBanco.getString("limiteCredito")));
				premium.setValorDaAnuidade(Double.parseDouble(resultadoDaTabelaDoBanco.getString("valoranuidade")));
				premium.getEndereco().setCep(resultadoDaTabelaDoBanco.getString("cep"));
				premium.getEndereco().setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				premium.getEndereco().setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				premium.getEndereco().setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				premium.getEndereco().setUf(resultadoDaTabelaDoBanco.getString("uf"));

				/*
				 * endereco.setCep(resultadoDaTabelaDoBanco.getString("cep"));
				 * endereco.setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				 * endereco.setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				 * endereco.setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				 * endereco.setUf(resultadoDaTabelaDoBanco.getString("uf"));
				 */

				listaPremium.add(premium);
			}

		} catch (Exception e) {
			System.out.println("Erro ao buscar a lista de premiums");
		} finally { // Esse é obrigatorio
			try {
				if (connectionBase != null) {
					connectionBase.close();// Se objeto connectionBase estiver aberto essa linha vai
											// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}
		}

		return listaPremium;

	}

	public boolean deletarPremium(String cpf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_correntista_premium where cpf = ?"; // Base do comando SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da class //
																					// Fabrica de conexã
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																					// comando SQL que vai ser
																					// prepara
			preparaOcomandoSQL.setString(1, cpf);// Coloca o valor no campo cpf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Premium Deletado");// Log

			deletar = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel deletar o correntista premium!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBase != null) {
					connectionBase.close();// Se objeto connectionBase estiver aberto essa linha vai
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

	public boolean alterarPremium(Premium premium) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_correntista_premium SET nome = ?, limitecredito = ? WHERE cpf = ? "; // Base
																													// do
																													// comando
		// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da classe //
																					// Fabrica de conexão
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o //
																					// comando SQL que vai se //
																					// preparado
			preparaOcomandoSQL.setString(1, premium.getNome());
			preparaOcomandoSQL.setString(2, premium.getLimiteCredito().toString()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, premium.getCpf());// Coloca o valor no campo cpf
			// Colocar o valor no campo nome

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("O Correntista premium foi registrado");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar o correntista premium!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connectionBase != null) {
					connectionBase.close();// Se objeto connectionBase estiver aberto essa linha vai
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
