package emiage.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = StudentCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentCode {
	
	public String value() default "MIAGE_";
	public String message() default "le code étudiant doit commencer par MIAGE_";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};

}
