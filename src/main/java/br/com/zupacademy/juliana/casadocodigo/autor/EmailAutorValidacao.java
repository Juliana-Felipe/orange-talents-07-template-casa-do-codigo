package br.com.zupacademy.juliana.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailAutorValidacao implements Validator {

    @Autowired
    AutorRepository autorRepository;


    @Override
    public boolean supports(Class clazz) {
        return AutorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors e) {
        if(e.hasErrors()){
            return;
        }
        AutorDTO autorDTO = (AutorDTO) obj;
        Optional<Autor> autor = autorRepository.findByEmail(autorDTO.getEmail());
        if (autor.isPresent()) {
            e.rejectValue("email", null,"este email: " + autorDTO.getEmail() + " já está cadastrado");
        }
    }
}
