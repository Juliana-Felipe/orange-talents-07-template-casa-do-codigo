package br.com.zupacademy.juliana.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
@Deprecated
    public Categoria() {
    }
}
