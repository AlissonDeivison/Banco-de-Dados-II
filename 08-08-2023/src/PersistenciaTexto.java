import java.io.FileWriter;

public class PersistenciaTexto {
    public static void main(String[] args) {
        String msg = "Exemplo de persitencia em arquivo de texto";
        
        try {
            FileWriter escritor = new FileWriter("arquivo.txt");
            escritor.write(msg);
            escritor.close();
            System.out.println("Dados gravados em arquivo");
        } catch (Exception e) {
            System.out.println("Erro ao salvar aquivo: " + e);
        }
    }
}
