package br.com.zupacademy.juliana.casadocodigo.localizacao;

import br.com.zupacademy.juliana.casadocodigo.Config.EstadoValido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadosController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastraPais(@RequestBody @Valid EstadoDTO estadoDTO) {
        Optional<Pais> possivelPais = paisRepository.findById(estadoDTO.getPaisId());
        if(possivelPais.isEmpty()){
            return new ResponseEntity("País não encontrado em nossa base de dados", HttpStatus.BAD_REQUEST);
        }
        Pais pais = possivelPais.get();
        Estado estado = estadoDTO.converte(pais);
        estadoRepository.save(estado);
        return ResponseEntity.ok().build();
    }
}
