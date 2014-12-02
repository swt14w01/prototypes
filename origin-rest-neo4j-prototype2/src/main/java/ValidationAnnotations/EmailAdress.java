package ValidationAnnotations;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

public @interface EmailAdress {
	
	@Target({TYPE, FIELD, ANNOTATION_TYPE}) 
	@Retention(RUNTIME)
	@Constraint(validatedBy = EmailAdressValidator.class)
	@Documented
	public @interface ValidEmail {   
	    String message() default "Invalid email";
	    Class<?>[] groups() default {}; 
	    Class<? extends Payload>[] payload() default {};
	}
}
