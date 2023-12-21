package com.etiya.rentacar.core.utilities.exceptions.problemDetails;

import com.etiya.rentacar.core.utilities.exceptions.problemDetails.ProblemDetails;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://mydomain.com/exceptions/business");
        setStatus("500");
    }
}
