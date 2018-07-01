package es.adrigrillo.cor.validation;

import es.adrigrillo.cor.ResponsabilitychainApplication;
import es.adrigrillo.cor.validation.validators.InstallationIdValidator;
import es.adrigrillo.cor.validation.validators.OrderValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResponsabilitychainApplication.class)
public class ValidatorTest {

    private static final List<Validator> VALIDATORS = new LinkedList<>();

    @Autowired
    private InstallationIdValidator installationIdValidator;
    @Autowired
    private OrderValidator orderValidator;

    @Test
    public void testWithCreation() {
        orderValidator.setRequiredOrder("order1");
        VALIDATORS.add(installationIdValidator);
        VALIDATORS.add(orderValidator);
        HashMap<String, String> mapToValidate = new HashMap<>();
        mapToValidate.put("INST", "1234");
        mapToValidate.put("ORDER", "order1");
        boolean result = validateMap(mapToValidate);
        Assert.assertTrue(result);
    }

    private boolean validateMap(HashMap<String, String> mapToValidate) {
        for (Validator validator : VALIDATORS) {
            ValidationResult result = validator.validate(mapToValidate);
            if (!result.isValid()) {
                throw new IllegalArgumentException("Validation failed");
            }
        }
        return true;
    }

}