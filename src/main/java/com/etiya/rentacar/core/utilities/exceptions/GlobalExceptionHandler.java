package com.etiya.rentacar.core.utilities.exceptions;

import com.etiya.rentacar.core.utilities.exceptions.types.BusinessException;
import com.etiya.rentacar.core.utilities.exceptions.types.BusinessProblemDetails;
import com.etiya.rentacar.core.utilities.exceptions.types.ValidationProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {

        Map<String,String> validationErrors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().stream().map(error ->
            validationErrors.put(error.getField(),error.getDefaultMessage())
        ).toList();

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(exception.getMessage());
        return businessProblemDetails;
    }
}
