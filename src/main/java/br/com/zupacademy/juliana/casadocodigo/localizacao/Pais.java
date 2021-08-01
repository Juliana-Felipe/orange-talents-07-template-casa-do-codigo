package br.com.zupacademy.juliana.casadocodigo.localizacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais() {
    }
}
