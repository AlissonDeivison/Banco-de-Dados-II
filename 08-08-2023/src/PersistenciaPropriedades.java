import java.io.FileOutputStream;
import java.util.Properties;

public class PersistenciaPropriedades {
    private String usuario;
    private String senha;

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public String getUsuario() {
        return usuario;
    }

    public void cadastrarUsuario (String usuario, String senha) {
    
        Properties props = new Properties();
        props.setProperty("usuario", usuario);
        props.setProperty("senha", senha);

        try {
            FileOutputStream arquivo = new FileOutputStream("config.properties");
            props.store(arquivo, "Arquivo de configuração do usuário");
            arquivo.close();
            System.out.println("Propriedades garvadas com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao gravar propriedades"+e.getMessage());
        }

    }

}
