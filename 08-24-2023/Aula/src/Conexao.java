import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

    String driver = "org.postgresql.Driver";
    String user = "postgres";
    String senha = "99764401";
    String url = "jdbc:postgresql://localhost:5432/postgres";

    public Conexao conectar() {
        try {
            Class.forName(driver);
            Connection con = null;

            con = (Connection) DriverManager.getConnection(url, user, senha);
            System.out.println("Conexão realizada com sucesso");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
