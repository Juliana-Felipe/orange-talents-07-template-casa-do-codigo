package br.com.zupacademy.juliana.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
        return new Categoria(nome);
    }
}
