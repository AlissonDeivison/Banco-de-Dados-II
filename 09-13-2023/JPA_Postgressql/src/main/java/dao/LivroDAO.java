package dao;


import model.Livro;

import javax.persistence.EntityManager;

import log.Log;

import java.io.IOException;
import java.util.List;


public class LivroDAO {

    private EntityManager em;

    //Criando instância do logger
    Log meuLogger = new Log("Log.txt");

    //Contrutor por atribuir o EntityManager vindo como parâmetro para o atributo em da classe local
    public LivroDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    //Método responsável por cadastrar um livro na base de dados
    public void cadastrar(Livro livro) {
        this.em.persist(livro);
        System.out.println("\nO " + livro + " foi criado com sucesso!\n");
        meuLogger.logger.info("\nO " + livro + " foi criado na base de dados!\n");
    }

    //Método responsável por atualizar um livro na base de dados
    public void atualizar(Livro livro) {
        this.em.merge(livro);
        System.out.println("\nLivro de id: " + livro.getId() + " agora possui o título: " + livro.getTitulo() + "\n");
        meuLogger.logger.info("\nLivro de id: " + livro.getId() + " teve seu título atualizado para: '" + livro.getTitulo() + "'\n");
    }

    //Método responsável por remover um livro da base de dados
    public void remover(Livro livro) {
        livro = em.merge(livro);
        this.em.remove(livro);
        System.out.println("\nO " + livro + " foi excluído com sucesso!\n");
        meuLogger.logger.info("\nO " + livro + " foi excluído na base de dados!\n");
    }

    //Método responsável por buscar um livro pelo ID no banco de dados
    public Livro buscarPorId(Long id) {
        return em.find(Livro.class, id);
    }

    //Método responsável por listar todos os livros e seus relacionamentos do banco de dados
    public List<Livro> buscarTodosOsLivros() {
        String jpql = "SELECT DISTINCT l FROM Livro l JOIN FETCH l.autores";
        return em.createQuery(jpql, Livro.class).getResultList();
    }

}
