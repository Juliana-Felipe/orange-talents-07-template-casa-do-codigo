package br.com.zupacademy.juliana.casadocodigo.livro;

import br.com.zupacademy.juliana.casadocodigo.Config.UniqueValue;
import br.com.zupacademy.juliana.casadocodigo.autor.Autor;
import br.com.zupacademy.juliana.casadocodigo.categoria.Categoria;
import br.com.zupacademy.juliana.casadocodigo.categoria.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroDTO {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max=500)
    private String resumo;

    @Lob
    private String sumario;

    @NotNull
    @DecimalMin(value = "20.00", inclusive = true)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer paginas;

    @NotBlank
    @ISBN
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="Brazil/East")
    private LocalDate dataLancamento;

    private Long categoriaId;

    private Long autorId;

    public LivroDTO(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="Brazil/East") LocalDate dataLancamento, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro convert(Autor autor, Categoria categoria) {
        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataLancamento,categoria,autor);
    }
}
