package br.com.zupacademy.juliana.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity salvaCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaDTO.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}
