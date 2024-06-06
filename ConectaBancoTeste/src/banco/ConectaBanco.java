package banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBanco {

	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/TESTE?Timezone=true&serverTimezone=UTC";
	
	public Connection criarConexaoComBaseTeste() {
		
		Connection conexaoBancoDadosTeste = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexaoBancoDadosTeste = DriverManager.getConnection(BANCO_URL,USUARIO,SENHA);
			System.out.println("Deu certo a conexao!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexao!!!");
		}
		return conexaoBancoDadosTeste;
	}
}
