package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import entidade.Cachorro;

public class DaoCachorro {

	public boolean salvarCachorro(Cachorro cachorro) {
		boolean salvamento = false;

		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão
		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "insert into tb_cachorro (nome, caf, corpelo) values (?, ?, ?)"; // Base do comando
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
	
	public List<Cachorro> retornaListaCachorros(){
		
		String comandoSqlBuscarCachorro = "select * from tb_cachorro";
		
		List<Cachorro> listaCachorro = new ArrayList<>();
		FabricaConexao conexaoFabricaConexao = new FabricaConexao();// Instacia a classe Fabrica de conexão

		Connection connectionBase = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		ResultSet resultadoTabelaCachorro =null;
		

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

}
