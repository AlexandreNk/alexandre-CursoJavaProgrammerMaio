package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/ANIMAL?Timezone=true&serverTimezone=UTC";

	/*
	private static String USUARIO = "urquav8yqcgb56gz"; // O usuario do banco
	private static String SENHA = "n4jInkrm1rKP7K0xb4w5"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://bkb9ggi5dnxk2nodlute-mysql.services.clever-cloud.com:3306/bkb9ggi5dnxk2nodlute?useTimezone=true&serverTimezone=UTC";//URL DO BANCO
	
	*/
	
	public Connection criarConexaoComBase() {

		Connection conexaoBancoDados = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexaoBancoDados = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);
			System.out.println("Deu certo a conexao!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Deu errado a conexao!!!");
		}
		return conexaoBancoDados;
	}
}
