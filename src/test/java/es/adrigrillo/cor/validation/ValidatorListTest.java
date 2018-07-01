package es.adrigrillo.cor.validation;

import es.adrigrillo.cor.ResponsabilitychainApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResponsabilitychainApplication.class)
public class ValidatorListTest {

    private List<Validator> VALIDATORS;

    @Autowired
    public void setValidators(List<Validator> validators) {
        this.VALIDATORS = validators;
    }

    @Test
    public void testWithCreation() {
        HashMap<String, String> mapToValidate = new HashMap<>();
        mapToValidate.put("INST", "1234");
        mapToValidate.put("COUNTRY", "ESP");
        mapToValidate.put("ORDER", "order1");
        List<ValidationResult> count = VALIDATORS.parallelStream()
                .map(s -> s.validate(mapToValidate))
                .filter(result -> !result.isValid())
                .collect(Collectors.toList() );
        // One error as the order validator is not configured
        Assert.assertEquals(1, count.size());
    }
}