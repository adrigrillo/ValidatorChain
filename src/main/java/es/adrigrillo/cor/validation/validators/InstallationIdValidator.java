package es.adrigrillo.cor.validation.validators;

import es.adrigrillo.cor.validation.ValidationResult;
import es.adrigrillo.cor.validation.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Map;


@Component
@Priority(value = 1)
public class InstallationIdValidator implements Validator {
    @Override
    public ValidationResult validate(Map<String, String> object) {
        ValidationResult res;
        String inst = object.get("INST");
        if (StringUtils.isNotBlank(inst)) {
            res = ValidationResult.valid();
        } else {
            res = ValidationResult.invalid("The installation is null");
        }
        return res;
    }
}
