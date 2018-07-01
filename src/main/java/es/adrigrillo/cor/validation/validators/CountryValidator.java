package es.adrigrillo.cor.validation.validators;

import es.adrigrillo.cor.validation.ValidationResult;
import es.adrigrillo.cor.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Map;

@Component
@Priority(value = 2)
public class CountryValidator implements Validator {
    @Override
    public ValidationResult validate(Map<String, String> object) {
        ValidationResult res;
        String country = object.get("COUNTRY");
        if (StringUtils.isNotBlank(country)) {
            res = ValidationResult.valid();
        } else {
            res = ValidationResult.invalid("The country is null");
        }
        return res;
    }
}
