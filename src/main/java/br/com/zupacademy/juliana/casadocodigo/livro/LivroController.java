package br.com.zupacademy.juliana.casadocodigo.livro;

import br.com.zupacademy.juliana.casadocodigo.autor.Autor;
import br.com.zupacademy.juliana.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.categoria.Categoria;
import br.com.zupacademy.juliana.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;


    @PostMapping
    public ResponseEntity cadastraLivro(@RequestBody @Valid LivroDTO livroDTO) {
        Optional<Categoria> possivelCategoria = categoriaRepository.findById(livroDTO.getCategoriaId());
        Optional<Autor> possivelAutor = autorRepository.findById(livroDTO.getAutorId());
        Categoria categoria = possivelCategoria.get();
        Autor autor = possivelAutor.get();
        Livro livro = livroDTO.convert(autor, categoria);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

}