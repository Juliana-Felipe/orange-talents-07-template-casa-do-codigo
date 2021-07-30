package br.com.zupacademy.juliana.casadocodigo.Config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsInDataBaseValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistsInDataBase {

    String message() default "Não possui registro em nossa base de dados";

    Class<?>[] groups() default{ };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();
}
