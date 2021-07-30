package br.com.zupacademy.juliana.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class ListaLivrosController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity< List<LivroDTOResponseList>> listagemLivros(){
        Iterable<Livro> lista = livroRepository.findAll();
        List<LivroDTOResponseList> listaDTO = new ArrayList<>();
        for (Livro l : lista) {
            LivroDTOResponseList livroDTOResponseList = new LivroDTOResponseList(l.getId(),l.getTitulo());
            listaDTO.add(livroDTOResponseList);
        }
        return new ResponseEntity<>(listaDTO, HttpStatus.OK);
    }
    
}
