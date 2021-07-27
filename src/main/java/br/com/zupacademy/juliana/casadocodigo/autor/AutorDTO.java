package br.com.zupacademy.juliana.casadocodigo.autor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotNull
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorDTO(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }
}
