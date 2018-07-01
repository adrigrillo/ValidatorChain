package es.adrigrillo.cor.validation;

import lombok.NonNull;

import java.util.Map;

public interface Validator {
    @NonNull
    ValidationResult validate(Map<String, String> object);
}

