package dao;


import model.Editora;

import javax.persistence.EntityManager;

import log.Log;

import java.io.IOException;

public class EditoraDAO {
    private EntityManager em;

    //Criando a instãncia do Logger
    Log meuLogger = new Log("Log.txt");

    //Contrutor por atribuir o EntityManager vindo como parâmetro para o atributo em da classe local
    public EditoraDAO(EntityManager em) throws IOException {
        this.em = em;
    }

    //Método responsável por cadastrar uma editora no banco de dados
    public void cadastrar(Editora editora) {
        this.em.persist(editora);
        System.out.println("\nA editora '" + editora.getNome() + "' foi criada com sucesso!\n");
        meuLogger.logger.info("\nA editora '" + editora.getNome() + "' foi criada na base de dados!\n");
    }

}