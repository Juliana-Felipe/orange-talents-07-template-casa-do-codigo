package br.com.zupacademy.juliana.casadocodigo.categoria;

import br.com.zupacademy.juliana.casadocodigo.Config.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
        return new Categoria(nome);
    }
}
