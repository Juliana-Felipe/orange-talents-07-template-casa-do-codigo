package br.com.zupacademy.juliana.casadocodigo.livro;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class LivroDTOResponseList {


    private Long id;

    private String titulo;

    public LivroDTOResponseList(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
