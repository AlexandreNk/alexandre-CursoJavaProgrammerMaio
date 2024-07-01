package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Basico;
import entidade.Endereco;

public class DaoBasico {

	public boolean salvarBasico(Basico basico) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		// String comandoSqlInsert = "insert into tb_correntista_basico (cpf, nome,
		// tipocliente, valoranuidade, limitecredito, limitesaque, cep,
		// localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?,?,?)"; // Base
		String comandoSqlInsert = "insert into tb_correntista_basico (cpf, nome, valoranuidade, limitesaque, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base
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

			preparaOcomandoSQL.setString(1, basico.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(2, basico.getNome()); // Colocar o valor no campo nome
			// preparaOcomandoSQL.setString(3, basico.getTipoCliente());
			preparaOcomandoSQL.setString(3, basico.getValorDaAnuidade().toString());
			preparaOcomandoSQL.setString(4, basico.getLimiteDeSaque().toString());
			preparaOcomandoSQL.setString(5, basico.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, basico.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7, basico.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, basico.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, basico.getEndereco().getUf());

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("O correntista baisco foi registrado");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar correntista basico!!!");

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

	public List<Basico> retornaListaDeBasicos() {

		String comandoSqlBuscarBasico = "select * from tb_correntista_basico";
		List<Basico> listaBasico = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da classe
																					// Fabrica de conexão
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlBuscarBasico);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				Basico basico = new Basico();
				Endereco endereco = new Endereco();

				basico.setEndereco(endereco);

				basico.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				basico.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				basico.setLimiteDeSaque(Double.parseDouble(resultadoDaTabelaDoBanco.getString("limiteSaque")));
				basico.setValorDaAnuidade(Double.parseDouble(resultadoDaTabelaDoBanco.getString("valorAnuidade")));
				basico.getEndereco().setCep(resultadoDaTabelaDoBanco.getString("cep"));
				basico.getEndereco().setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				basico.getEndereco().setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				basico.getEndereco().setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				basico.getEndereco().setUf(resultadoDaTabelaDoBanco.getString("uf"));

				/*
				 * endereco.setCep(resultadoDaTabelaDoBanco.getString("cep"));
				 * endereco.setBairro(resultadoDaTabelaDoBanco.getString("bairro"));
				 * endereco.setLogradouro(resultadoDaTabelaDoBanco.getString("logradouro"));
				 * endereco.setLocalidade(resultadoDaTabelaDoBanco.getString("localidade"));
				 * endereco.setUf(resultadoDaTabelaDoBanco.getString("uf"));
				 */

				listaBasico.add(basico);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao buscar a lista de correntistas basicos");
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

		return listaBasico;

	}

	public boolean deletarBasico(String cpf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_correntista_basico where cpf = ?"; // Base do comando SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBaseBancoJava(); // Recebe o objeto de
																					// conexão da class //
																					// Fabrica de conexã
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlDelete);// Armazena a conexão e o
																					// comando SQL que vai ser
																					// prepara
			preparaOcomandoSQL.setString(1, cpf);// Coloca o valor no campo cpf

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Basico Deletado");// Log

			deletar = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel deletar o correntista basico!!!");

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

	public boolean alterarBasico(Basico basico) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_correntista_basico SET nome = ?, limitesaque = ? WHERE cpf = ? "; // Base
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
			preparaOcomandoSQL.setString(1, basico.getNome());
			preparaOcomandoSQL.setString(2, basico.getLimiteDeSaque().toString()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, basico.getCpf());// Coloca o valor no campo cpf
			// Colocar o valor no campo nome

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("O correntista basico foi alterado");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar a correntista basico!!!");

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
