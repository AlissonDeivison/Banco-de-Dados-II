package aula5atividadedefixacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelecionandoDadosDaTabelaProduto {

	private Connection connection;
	private Statement statement;
	
	public SelecionandoDadosDaTabelaProduto() throws ClassNotFoundException {
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
			ResultSet set = statement.executeQuery("SELECT * from produto");
			ResultSetMetaData data = set.getMetaData();
			int numeroDeColunas = data.getColumnCount();
			System.out.println("Relacao de pessoas cadastradas");
			for (int i = 1; i <= numeroDeColunas; i++) {
				System.out.printf("%-8s\t", data.getColumnName(i));
			}
			while (set.next()){
				System.out.println();
				String linha = "";
				for (int x=1; x<=numeroDeColunas; x++){
					System.out.printf("%-8s\t",set.getObject(x));
					linha = linha + " " + set.getObject(x);
				}
			}
		}catch (Exception e) {
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
		SelecionandoDadosDaTabelaProduto sec = new SelecionandoDadosDaTabelaProduto();
	}
}
