package com.fischer.thiago.v1.exceptions.handler;

import com.fischer.thiago.v1.exceptions.PersonNotFoundException;
import com.fischer.thiago.v1.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomiseResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestsExceptions(Exception e, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
