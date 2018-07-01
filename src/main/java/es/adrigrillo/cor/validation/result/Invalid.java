package es.adrigrillo.cor.validation.result;

import es.adrigrillo.cor.validation.ValidationResult;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class Invalid implements ValidationResult {

    private String reason;

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public Optional<String> getReason() {
        return Optional.of(reason);
    }
}
