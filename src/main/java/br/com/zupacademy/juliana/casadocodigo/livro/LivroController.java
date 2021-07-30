package br.com.zupacademy.juliana.casadocodigo.livro;

import br.com.zupacademy.juliana.casadocodigo.autor.Autor;
import br.com.zupacademy.juliana.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.juliana.casadocodigo.categoria.Categoria;
import br.com.zupacademy.juliana.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private CategoriaRepository categoriaRepository;

    private AutorRepository autorRepository;

    private LivroRepository livroRepository;

    public LivroController(CategoriaRepository categoriaRepository, AutorRepository autorRepository, LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity cadastraLivro(@RequestBody @Valid LivroDTO livroDTO) {
        Optional<Categoria> possivelCategoria = categoriaRepository.findById(livroDTO.getCategoriaId());
        Optional<Autor> possivelAutor = autorRepository.findById(livroDTO.getAutorId());
        if (possivelAutor.isEmpty()) {
            return new ResponseEntity<>("Por favor confira os dados do autor não conseguimos encontrar em nossa base de dados.", HttpStatus.BAD_REQUEST);
        }
        if (possivelCategoria.isEmpty()) {
            return new ResponseEntity<>("Por favor confira os dados da categoria, não conseguimos encontrar em nossa base de dados.", HttpStatus.BAD_REQUEST);
        }
        Categoria categoria = possivelCategoria.get();
        Autor autor = possivelAutor.get();
        Livro livro = livroDTO.convert(autor, categoria);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Livro>> lista(){
        List<Livro> liste = (List<Livro>) livroRepository.findAll();
        return  new ResponseEntity<>(liste, HttpStatus.OK);
    }
}