import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
    public static void main(String[] args) throws Exception {
        Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Harry_Potter").get() ;
        String conteudo = doc.select("h1, h2, h3, h4").toString();
        try {
            FileWriter escritor = new FileWriter("arquivo.txt");
            escritor.write(conteudo);
            escritor.close();
            System.out.println("Arquivo com títulos salvo!");

        } catch (Exception e) {
            System.out.println("Erro ao gravar aquivo" + e.getMessage());
        }
    }
}
