package com.example.VotingSystem.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.VotingSystem.exception.ValidationException;

@Aspect
@Component
public class ValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

    @Before("execution(* com.example.VotingSystem.controller.*.*(..)) && args(.., bindingResult)")
    public void validateInput(JoinPoint joinPoint, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getField())
                        .append(": ")
                        .append(error.getDefaultMessage())
                        .append(". ");
            }
            logger.error("Validation error in method {}: {}", joinPoint.getSignature().toShortString(), errorMessage);
            throw new ValidationException("Validation error: " + errorMessage.toString());
        }
    }
}
