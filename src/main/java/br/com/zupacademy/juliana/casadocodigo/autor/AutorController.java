package br.com.zupacademy.juliana.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cadastraAutor(@RequestBody @Valid AutorDTO autorDTO) {
        Autor autor = autorDTO.converter();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();

    }


}
