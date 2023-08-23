import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Apartamento implements Serializable{
    private int numero;
    private String inquilino;
    private double valorAluguel;

    public String getInquilino() {
        return inquilino;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void gerarBinario(Apartamento a) {

        try {
            FileOutputStream file = new FileOutputStream("objeto.bin");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(a);
            obj.close();
            file.close();
            System.out.println("Arquivo Gerado com sucesso");
        } catch (Exception e) {
            System.out.println("Não foi possível gerar o arquivo binário: " + e);
        }

    }
}
