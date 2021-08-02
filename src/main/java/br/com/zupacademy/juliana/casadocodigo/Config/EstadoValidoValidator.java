package br.com.zupacademy.juliana.casadocodigo.Config;

import br.com.zupacademy.juliana.casadocodigo.localizacao.Estado;
import br.com.zupacademy.juliana.casadocodigo.localizacao.EstadoDTO;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Locale;

public class EstadoValidoValidator implements ConstraintValidator<EstadoValido, EstadoDTO> {

    @PersistenceContext
    private EntityManager entityManager;

   @Override
    public boolean isValid(EstadoDTO value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from " + Estado.class.getName() + " e where e.nome = :nome and e.pais.id = :paisId");
        query.setParameter("nome", value.getNome().toLowerCase(Locale.ROOT).trim());
        query.setParameter("paisId", value.getPaisId());

        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "O registro de " + Estado.class.getName() + " " + value.getNome() + " foi encontrado para mais de um país.");
        return list.isEmpty();//Alberto !list..isEmpty();
    }
}