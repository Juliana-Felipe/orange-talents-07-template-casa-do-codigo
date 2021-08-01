package br.com.zupacademy.juliana.casadocodigo.Config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {EstadoValidoValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface EstadoValido {

    String message() default "Estado inválido para este país";

    Class<?>[] groups() default{ };

    Class<? extends Payload>[] payload() default { };

}
