package com.serhat.spring.productrestapi.web.config;

import io.micrometer.core.instrument.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;
import org.apache.commons.collections4.CollectionUtils;


import javax.validation.*;
import java.util.*;
import java.util.stream.*;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        List<String> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
        return getExceptionResponseEntity(HttpStatus.OK, request, validationErrors);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException exception, WebRequest request) {
        List<String> validationErrors = exception.getConstraintViolations().stream().
                map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
        return getExceptionResponseEntity(HttpStatus.BAD_REQUEST, request, validationErrors);
    }

    private ResponseEntity<Object> getExceptionResponseEntity(final HttpStatus status, WebRequest request, List<String> errors) {
        final Map<String, Object> body = new LinkedHashMap<>();
        final String errorsMessage = CollectionUtils.isNotEmpty(errors) ? errors.stream().filter(StringUtils::isNotEmpty).collect(Collectors.joining(",")):status.getReasonPhrase();
        final String path = request.getDescription(false);
        body.put("code", 1000);
        body.put("data", null);
        body.put("message", errorsMessage);
        body.put("responseEnum", "ERROR");
        body.put("success", false);
        return new ResponseEntity<>(body, status);
    }
}
