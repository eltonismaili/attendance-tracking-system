package com.example.attendancetrackingsystem.infrastructure;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEqualValidator implements ConstraintValidator<NotEquals, Object> {

    private String value;

    @Override
    public void initialize(NotEquals constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true; // Allow null values, handle with @NotNull if needed
        }
        return !object.equals(value);
    }
}
