package aula5atividadedefixacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserindoDadosNaTabelaProduto {
	
	private Connection connection;
	private Statement statement;

	public InserindoDadosNaTabelaProduto() throws ClassNotFoundException {
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
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO produto (codProduto, produto) values (1, 'Arroz');");
			statement.executeUpdate("INSERT INTO produto (codProduto, produto) values (2, 'Feijão');");
			statement.executeUpdate("INSERT INTO produto (codProduto, produto) values (3, 'Macarrão');");
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
		InserindoDadosNaTabelaProduto inserindo = new InserindoDadosNaTabelaProduto();
	}
}
