package es.adrigrillo.cor.validation;

import es.adrigrillo.cor.validation.result.Invalid;
import es.adrigrillo.cor.validation.result.ValidationSupport;

import java.util.Optional;

public interface ValidationResult {
    static ValidationResult valid(){
        return ValidationSupport.valid();
    }

    static ValidationResult invalid(String reason){
        return new Invalid(reason);
    }

    boolean isValid();

    Optional<String> getReason();
}
