package hr.fer.zpr.marinpetrunic.healthmon.controllers.validation;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author MarinPetrunic
 */
@Component
public class ExistsValidator implements ConstraintValidator<Exists, Integer> {

    @Autowired
    private DSLContext dsl;

    private String table;

    private String column;


    @Override
    public void initialize(Exists constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.column = constraintAnnotation.column();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null
                || dsl.select(DSL.field(column)).from(DSL.table(table)).where(DSL.field(column).equal(value)).fetch().size() > 0;
    }
}
