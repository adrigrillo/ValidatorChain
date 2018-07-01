package es.adrigrillo.cor.validation.result;

import es.adrigrillo.cor.validation.ValidationResult;

import java.util.Optional;

public final class ValidationSupport {
    private static final ValidationResult valid = new ValidationResult() {
        public boolean isValid() {
            return true;
        }

        public Optional<String> getReason() {
            return Optional.empty();
        }
    };

    private ValidationSupport() {
    }

    public static ValidationResult valid() {
        return valid;
    }
}
