public class App {
    public static void main(String[] args) {
        Apartamento novoAp = new Apartamento();
        novoAp.setInquilino("Alisson Deivison Silva Pereira");
        novoAp.setNumero(202);
        novoAp.setValorAluguel(430.00);
        novoAp.gerarBinario(novoAp);

        Pessoa p = new Pessoa();
        p.setIdade(30);
        p.setNome("Alisson Deivison");
        p.gerarTexto(p);

        PersistenciaPropriedades pp = new PersistenciaPropriedades();
        pp.cadastrarUsuario("Alisson Deivison", "123456789");
    }
}
