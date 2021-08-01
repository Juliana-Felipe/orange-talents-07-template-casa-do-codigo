package br.com.zupacademy.juliana.casadocodigo.localizacao;

import br.com.zupacademy.juliana.casadocodigo.Config.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class PaisDTO {

    @NotBlank
    @UniqueValue(domainClass = Pais.class,fieldName = "nome")
    private String nome;



    public String getNome() {
        return nome;
    }

    public Pais converte() {
        return new Pais(nome);
    }
}
