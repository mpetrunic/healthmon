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
@Constraint(validatedBy = ExistsValidator.class)
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {

    String table();

    String column();

    String message() default "Must exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
