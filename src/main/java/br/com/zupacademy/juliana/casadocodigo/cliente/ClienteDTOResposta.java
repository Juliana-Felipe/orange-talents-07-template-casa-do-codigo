package br.com.zupacademy.juliana.casadocodigo.cliente;

public class ClienteDTOResposta {
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteDTOResposta(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
