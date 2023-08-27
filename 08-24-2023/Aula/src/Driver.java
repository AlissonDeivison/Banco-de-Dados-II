public class Driver {
    public void carregarDrive() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver carregado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}
