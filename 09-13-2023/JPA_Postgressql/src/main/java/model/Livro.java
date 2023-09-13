package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ISBN;
    private String titulo;
    private int ano;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Editora editora;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    public Livro () {}

    public Livro(String titulo, int ano, long ISBN, Categoria categoria, Editora editora, List<Autor> autores) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.ano = ano;
        this.categoria = categoria;
        this.editora = editora;
        this.autores = autores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", ISBN=" + ISBN +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", categoria=" + categoria +
                ", editora=" + editora +
                '}';
    }
}
