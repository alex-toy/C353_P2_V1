package emiage.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentCodeConstraintValidator 
	implements ConstraintValidator<StudentCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(StudentCode theStudentCode) {
		coursePrefix = theStudentCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		boolean result;
		
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}
		else {
			result = true;
		}
		
		return result;
	}
}








