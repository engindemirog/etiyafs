package com.etiya.rentacar.core.utilities.exceptions.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@Data

public class ValidationProblemDetails extends ProblemDetails{

    public ValidationProblemDetails(){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("http://mydomain.com/exceptions/validation");
        setStatus("500");
    }
    private Map<String,String> errors;
}
