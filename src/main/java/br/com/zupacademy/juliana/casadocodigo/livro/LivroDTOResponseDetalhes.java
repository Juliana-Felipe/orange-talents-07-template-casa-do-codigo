package br.com.zupacademy.juliana.casadocodigo.livro;

import br.com.zupacademy.juliana.casadocodigo.Config.ExistsInDataBase;
import br.com.zupacademy.juliana.casadocodigo.autor.Autor;
import br.com.zupacademy.juliana.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDTOResponseDetalhes {


    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer paginas;

    private String isbn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @ExistsInDataBase(domainClass = Categoria.class, fieldName = "id")
    private Categoria categoria;

    @ExistsInDataBase(domainClass = Autor.class, fieldName = "id")
    private Autor autor;

    @Valid
    public LivroDTOResponseDetalhes(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.dataLancamento = livro.getDataLancamento();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
