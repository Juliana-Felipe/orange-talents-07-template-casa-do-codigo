package br.com.zupacademy.juliana.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {
     Optional<Autor> findByEmail(String email);
}
