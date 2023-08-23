import java.io.FileWriter;
import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }

    public void gerarTexto (Pessoa p){
    
        String saudacao = String.format("Olá, %s! Você tem %d anos.", p.nome,p.idade);
        
        try {
            FileWriter newFile = new FileWriter("saudacao.txt");
            newFile.write(saudacao);
            newFile.close();
            System.out.println("Arquivo Gerado com sucesso");
        } catch (Exception e) {
            System.out.println("Não foi possível gerar o arquivo: " + e);
        } 
    }
}
