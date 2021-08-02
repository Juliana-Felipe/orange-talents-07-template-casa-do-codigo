package br.com.zupacademy.juliana.casadocodigo.cliente;

import br.com.zupacademy.juliana.casadocodigo.localizacao.Estado;
import br.com.zupacademy.juliana.casadocodigo.localizacao.EstadoRepository;
import br.com.zupacademy.juliana.casadocodigo.localizacao.Pais;
import br.com.zupacademy.juliana.casadocodigo.localizacao.PaisRepository;
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
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteDTOResposta> cadastraCliente(@RequestBody @Valid ClienteDTORequisicao clienteDTORequisicao) {
        Optional<Pais> possivelPais = paisRepository.findById(clienteDTORequisicao.getPaisId());
        if (possivelPais.isEmpty()) {
            return new ResponseEntity("País não enconttrado em nossa base de dados", HttpStatus.BAD_REQUEST);
        }
        Pais pais = possivelPais.get();
        if (clienteDTORequisicao.getEstadoId() != null) {
            Optional<Estado> possivelEstado = estadoRepository.findById(clienteDTORequisicao.getEstadoId());
            if (possivelEstado.isEmpty()) {
                return new ResponseEntity("Estado não enconttrado em nossa base de dados", HttpStatus.BAD_REQUEST);
            }
            Estado estado = possivelEstado.get();
            boolean verificacao = Estado.estadoValido(pais, estado);
            if (verificacao == true) {
                Cliente cliente = clienteDTORequisicao.converte(pais, estado);
            }
            if (verificacao == false) {
                return new ResponseEntity("Estado não correspondente ao país informado", HttpStatus.BAD_REQUEST);
            }
        }

        Cliente cliente = clienteDTORequisicao.converte(pais);
        clienteRepository.save(cliente);
        ClienteDTOResposta resposta = new ClienteDTOResposta(cliente.getId(), cliente.getNome());
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
