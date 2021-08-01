package br.com.zupacademy.juliana.casadocodigo.localizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastraPais(@RequestBody @Valid PaisDTO paisDTO) {
        Pais pais = paisDTO.converte();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }
}
