package dao;

import log.Log;
import model.Categoria;

import javax.persistence.EntityManager;
import java.io.IOException;

public class CategoriaDAO {

    private EntityManager em;

    //Criando instância do Logger
    Log meuLogger = new Log("Log.txt");

    //Contrutor por atribuir o EntityManager vindo como parâmetro para o atributo em da classe local
    public CategoriaDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    //Método responsável por cadastrar uma categoria no banco de dados
    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
        System.out.println("\nA categoria '" + categoria.getNome() + "' foi criada com sucesso!\n");
        meuLogger.logger.info("\nA categoria '" + categoria.getNome() + "' foi criada na base de dados!\n");
    }

}