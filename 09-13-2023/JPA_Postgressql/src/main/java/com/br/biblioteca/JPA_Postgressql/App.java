package com.br.biblioteca.JPA_Postgressql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.EditoraDAO;
import dao.LivroDAO;
import model.Autor;
import model.Categoria;
import model.Editora;
import model.Livro;
import util.JPAUtil;

public class App {
    public static void main(String[] args) throws IOException {

        //Criando instância da EntityManager para poder começar as transações no banco de dados
        EntityManager em = JPAUtil.getEntityManager();

        //Criando as instâncias das classes DAO
        LivroDAO livroDAO = new LivroDAO(em);
        EditoraDAO editoraDAO = new EditoraDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        AutorDAO autorDAO = new AutorDAO(em);

        //Criando as instâncias de categoria
        Categoria categoria1 = new Categoria("Ação");
        Categoria categoria2 = new Categoria("Comédia");

        //Criando os objetos contendo as editoras
        Editora editora1 = new Editora("Aleph");
        Editora editora2 = new Editora("Rocco");

        //Criando os objeto contendo os autores
        Autor autor1 = new Autor("Lucas Lschlestein");
        Autor autor2 = new Autor("André Santos");

        //Criando a lista de autores para passar como parâmetro na hora da criação do Livro
        List<Autor> autores = new ArrayList<>();
        autores.add(autor1);
        autores.add(autor2);

        //Criando os objetos do tipo Livro
        Livro harryPotter = new Livro("Harry Potter", 1999, 123456789, categoria1, editora1, autores);
        Livro piorQueTaNaoFica = new Livro("Pior que tá não fica", 2015, 15198487, categoria2, editora2, autores);
        Livro oEspadachimDeCarvao = new Livro("O Espadachim de carvão", 2010, 15198487, categoria1, editora2, autores);

        //Iniciando a transação com o banco de dados
        em.getTransaction().begin();

//        //Persistindo as instâncias de categoria criadas anteriormente
//        categoriaDAO.cadastrar(categoria1);
//        categoriaDAO.cadastrar(categoria2);
//
//        //Persistindo as instâncias de editora criadas anteriormente
//        editoraDAO.cadastrar(editora1);
//        editoraDAO.cadastrar(editora2);
//
//        //Persistindo as instâncias de autor criadas anteriormente
//        autorDAO.cadastrar(autor1);
//        autorDAO.cadastrar(autor2);
//
//        //Persistindo as instâncias de livros criadas anteriormente
//        livroDAO.cadastrar(harryPotter);
//        livroDAO.cadastrar(piorQueTaNaoFica);
//        livroDAO.cadastrar(oEspadachimDeCarvao);

//        //Buscando todos os livros cadastrados
//        List<Livro> todosLivros = livroDAO.buscarTodosOsLivros();
//        todosLivros.forEach(livro -> {
//            System.out.println("\nID do Livro: " + livro.getId());
//            System.out.println("ISBN: " + livro.getISBN());
//            System.out.println("Título: " + livro.getTitulo());
//            System.out.println("Ano de lançamento: " + livro.getAno());
//            System.out.println("Categoria: " + livro.getCategoria().getNome());
//            System.out.println("Editora: " + livro.getEditora().getNome());
//            System.out.println("Autores: " + livro.getAutores());
//        });

//        //Atualizando um livro
//        Livro atualizaLivro = em.find(Livro.class, 1l);
//        System.out.println("Livro: " + atualizaLivro);
//        atualizaLivro.setTitulo("Senhor dos Anéis");
//        livroDAO.atualizar(atualizaLivro);

//        //Buscando livro por ID
//        Livro livro = livroDAO.buscarPorId(1l);
//        System.out.println("\n" + livro.getId());
//        System.out.println(livro.getISBN());
//        System.out.println(livro.getTitulo());
//        System.out.println(livro.getAno());
//        System.out.println(livro.getCategoria().getNome());
//        System.out.println(livro.getEditora().getNome());
//        System.out.println("Autores: " + livro.getAutores());

//        //Removendo livro
//        livroDAO.remover(livro);

        //Finalizando a transação com o banco de dados
        em.getTransaction().commit();
        //Fechando conexão com o banco de dados
        em.close();
    }
}
