package br.com.zupacademy.juliana.casadocodigo.localizacao;

import br.com.zupacademy.juliana.casadocodigo.Config.EstadoValido;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoValido
public class EstadoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado converte(Pais pais) {
        return new Estado(nome, pais);
    }
}
