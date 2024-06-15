package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	private static String USUARIO = "root";
	private static String SENHA = "root";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/ANIMAL?Timezone=true&serverTimezone=UTC";

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
