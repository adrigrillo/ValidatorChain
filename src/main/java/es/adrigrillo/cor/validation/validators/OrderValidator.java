package es.adrigrillo.cor.validation.validators;

import es.adrigrillo.cor.validation.ValidationResult;
import es.adrigrillo.cor.validation.Validator;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Map;
import java.util.Objects;

@Component
@Priority(value = 3)
public class OrderValidator implements Validator {

    @Setter
    private String requiredOrder;

    @Override
    public ValidationResult validate(Map<String, String> object) {
        String order = object.get("ORDER");
        ValidationResult result;
        if (Objects.equals(requiredOrder, order)) {
            result = ValidationResult.valid();
        } else {
            result = ValidationResult.invalid("No order configured");
        }
        return result;
    }
}
