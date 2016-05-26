package hr.fer.zpr.marinpetrunic.healthmon.controllers.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author MarinPetrunic
 */
@Documented
@Constraint(validatedBy = UniqueValidator.class)
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String table();

    String column();

    String message() default "Must be unique value.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
