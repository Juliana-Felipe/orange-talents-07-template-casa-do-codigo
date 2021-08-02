package br.com.zupacademy.juliana.casadocodigo.cliente;

import br.com.zupacademy.juliana.casadocodigo.Config.CPFOrCNPJ;
import br.com.zupacademy.juliana.casadocodigo.localizacao.Estado;
import br.com.zupacademy.juliana.casadocodigo.localizacao.Pais;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPFOrCNPJ
    @NotBlank
    private String documento; //(cpf/cnpj)

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente() {
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Pais pais, Estado estado, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
