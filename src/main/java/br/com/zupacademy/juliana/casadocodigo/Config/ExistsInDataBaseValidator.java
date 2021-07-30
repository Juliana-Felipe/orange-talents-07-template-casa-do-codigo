package br.com.zupacademy.juliana.casadocodigo.Config;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsInDataBaseValidator implements ConstraintValidator<ExistsInDataBase, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsInDataBase anotation) {
        domainAttribute=anotation.fieldName();
        klass= anotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select * from "+klass.getName()+" where " + domainAttribute + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size()!=0, "O registro de " +klass.getName()+ " com o atributo " + domainAttribute+ " não foi encontrado em nossa base de dados.");
        return list.contains(value);
    }
}
