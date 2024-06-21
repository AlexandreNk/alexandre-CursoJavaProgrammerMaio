package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Cobra;
import entidade.Endereco;

public class DaoCobra {

	public boolean salvarCobra(Cobra cobra) {
		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_cobra (nome, caf, tipoveneno, preco, cep, localidade,logradouro, bairro,uf) values (?,?,?,?,?,?,?,?,?)"; // Base do comando
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
			preparaOcomandoSQL.setString(4, cobra.getPreco().toString());
			preparaOcomandoSQL.setString(5, cobra.getEndereco().getCep());
			preparaOcomandoSQL.setString(6, cobra.getEndereco().getLocalidade());
			preparaOcomandoSQL.setString(7, cobra.getEndereco().getLogradouro());
			preparaOcomandoSQL.setString(8, cobra.getEndereco().getBairro());
			preparaOcomandoSQL.setString(9, cobra.getEndereco().getUf());
			
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

	public List<Cobra> retornaListaCobra() {

		String comandoSqlBuscarCobra = "select * from tb_cobra";

		List<Cobra> listaCobra = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoTabelaCobra = null;

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de conexão da
																			// classe Fabrica de conexão

			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlBuscarCobra);// Armazena a conexão e o
																						// comando SQL que vai ser
																						// preparado
			resultadoTabelaCobra = preparaOcomandoSQL.executeQuery();

			while (resultadoTabelaCobra.next()) {
				Cobra cobra = new Cobra();
				Endereco endereco = new Endereco();

				cobra.setNome(resultadoTabelaCobra.getString("nome"));
				cobra.setCAF(resultadoTabelaCobra.getString("CAF"));
				cobra.setTipoVeneno(resultadoTabelaCobra.getString("tipoveneno"));
				cobra.setPreco(Double.parseDouble(resultadoTabelaCobra.getString("preco")));				
				endereco.setCep(resultadoTabelaCobra.getString("cep"));
				endereco.setBairro(resultadoTabelaCobra.getString("bairro"));
				endereco.setLogradouro(resultadoTabelaCobra.getString("logradouro"));
				endereco.setLocalidade(resultadoTabelaCobra.getString("localidade"));
				endereco.setUf(resultadoTabelaCobra.getString("uf"));
				cobra.setEndereco(endereco);
				listaCobra.add(cobra);

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

		return listaCobra;
	}

	public boolean deletarCobra(String caf) {

		boolean deletar = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlDelete = "delete from tb_cobra where caf = ?"; // Base do comando SQL

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

	public boolean alterarCobra(Cobra cobra) {

		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "UPDATE tb_cobra SET nome = ?, tipoveneno = ? WHERE caf = ? "; // Base do comando
																									// SQL

		try {
			connectionBase = conexaoFabricaConexao.criarConexaoComBase(); // Recebe o objeto de
																			// conexão da classe // Fabrica de conexão
			preparaOcomandoSQL = connectionBase.prepareStatement(comandoSqlInsert);// Armazena a conexão e o // comando
																					// SQL que vai se // preparado
			preparaOcomandoSQL.setString(1, cobra.getNome());
			preparaOcomandoSQL.setString(2, cobra.getTipoVeneno()); // Colocar o valor no campo email
			preparaOcomandoSQL.setString(3, cobra.getCAF());// Coloca o valor no campo cpf
			// Colocar o valor no campo nome

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("A cobra foi registrada");// Log

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
