public class App {
    public static void main(String[] args) throws Exception {
        
        Driver d = new Driver();
        d.carregarDrive();
        Conexao c = new Conexao();
        c.conectar();
    }
}
