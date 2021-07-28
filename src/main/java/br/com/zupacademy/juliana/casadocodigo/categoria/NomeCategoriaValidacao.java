package br.com.zupacademy.juliana.casadocodigo.categoria;

import br.com.zupacademy.juliana.casadocodigo.autor.Autor;
import br.com.zupacademy.juliana.casadocodigo.autor.AutorDTO;
import br.com.zupacademy.juliana.casadocodigo.autor.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Component
public class NomeCategoriaValidacao implements Validator {

        @Autowired
        CategoriaRepository categoriaRepository;


        @Override
        public boolean supports(Class clazz) {
            return CategoriaDTO.class.equals(clazz);
        }

        @Override
        public void validate(Object obj, Errors e) {
            if(e.hasErrors()){
                return;
            }
            CategoriaDTO categoriaDTO = (CategoriaDTO) obj;
            Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaDTO.getNome());
            if (categoria.isPresent()) {
                e.rejectValue("nome", null,"este nome: " + categoriaDTO.getNome() + " já está cadastrado");
            }
        }
}
