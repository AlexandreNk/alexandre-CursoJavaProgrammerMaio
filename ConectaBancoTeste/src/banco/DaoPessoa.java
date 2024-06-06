package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoPessoa {

		public boolean salvarPessoaNobanco() {
			boolean salvamento = false;
			
			ConectaBanco conectaBanco = new ConectaBanco();
			Connection conectaBancoTeste= null;
			PreparedStatement preparaOcomandoSql = null;
			
			
			String comandoSqlInsert = "Insert into pessoa (cpf, nome, email) values(?, ?, ?)";
			
			
			try {
				conectaBancoTeste = conectaBanco.criarConexaoComBaseTeste();
			
				preparaOcomandoSql = conectaBancoTeste.prepareStatement(comandoSqlInsert);
				
				preparaOcomandoSql.setString(1, "123");
				preparaOcomandoSql.setString(2, "Alexandre");
				preparaOcomandoSql.setString(3, "email@email.com");
				preparaOcomandoSql.execute();
				
				salvamento = true;
				
				System.out.println("A pessoa foi registrada");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Não foi possivel salvar a pessoa");
			}finally {
				try {
					if(conectaBancoTeste != null) {
						conectaBancoTeste.close();
					}
					if(preparaOcomandoSql != null) {
						preparaOcomandoSql.close();
					}
				} catch (Exception e2) {
					System.out.println("Não foi possivel fechar a conexão");
				}
			}
			
			return salvamento;
							
		}
}
