package br.com.zupacademy.juliana.casadocodigo.localizacao;

import br.com.zupacademy.juliana.casadocodigo.Config.EstadoValido;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado() {
    }

    public Pais getPais() {
        return pais;
    }
    public static boolean estadoValido(Pais pais, Estado estado) {
        Long idPaisEstado = estado.getPais().getId();
        if(idPaisEstado == pais.getId()) {
            return true;
        }
        return false;
    }
}
