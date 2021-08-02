package br.com.zupacademy.juliana.casadocodigo.cliente;

import br.com.zupacademy.juliana.casadocodigo.Config.CPFOrCNPJ;
import br.com.zupacademy.juliana.casadocodigo.Config.UniqueValue;
import br.com.zupacademy.juliana.casadocodigo.localizacao.Estado;
import br.com.zupacademy.juliana.casadocodigo.localizacao.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ClienteDTORequisicao {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
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
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente converte(Pais pais, Estado estado) {
                 return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
         }

    public Cliente converte(Pais pais) {
        return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
    }


}
