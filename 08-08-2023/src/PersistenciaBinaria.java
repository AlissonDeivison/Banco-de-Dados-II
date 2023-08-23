import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class PersistenciaBinaria {
    public static void main(String[] args) {
        Pessoa aluno = new Pessoa();
        aluno.setIdade(30);
        aluno.setNome("Alisson Deivison Silva Pereira");

        try {
            FileOutputStream arquivo = new FileOutputStream("dados.bin");
            ObjectOutputStream escritor = new ObjectOutputStream(arquivo);
            escritor.writeObject(aluno);
            escritor.close();
            arquivo.close();
            System.out.println("Arquivo gerado com sucesso");

        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivo: "+ e);
        }

    }
}
