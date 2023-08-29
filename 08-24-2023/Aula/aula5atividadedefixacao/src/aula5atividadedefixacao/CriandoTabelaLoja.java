package aula5atividadedefixacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriandoTabelaLoja {

	private Connection connection;
	private Statement statement;

	public CriandoTabelaLoja() throws ClassNotFoundException {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String pass = "tutu321";
		String url = "jdbc:postgresql://localhost:5432/Loja";

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "CREATE TABLE produto(codProduto integer PRIMARY KEY, produto VARCHAR(50))";

		try {
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) throws ClassNotFoundException {
		CriandoTabelaLoja tabela = new CriandoTabelaLoja();
	}
}
