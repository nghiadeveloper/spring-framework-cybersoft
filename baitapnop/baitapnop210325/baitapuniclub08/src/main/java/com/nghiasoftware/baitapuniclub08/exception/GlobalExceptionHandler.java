package com.nghiasoftware.baitapuniclub08.exception;

import com.nghiasoftware.baitapuniclub08.payload.response.BadRequestResponse;
import com.nghiasoftware.baitapuniclub08.payload.response.ErrMessage;
import com.nghiasoftware.baitapuniclub08.payload.response.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<BadRequestResponse<ErrMessage>> handleInvalidRequest(MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<>(new BadRequestResponse<>(new ErrMessage(ex.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<BadRequestResponse<ErrMessage>> handleInvalidFormat(HttpMessageNotReadableException ex, WebRequest request) {
        return new ResponseEntity<>(new BadRequestResponse<>(new ErrMessage(ex.getMessage())), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<NotFoundResponse<ErrMessage>> handleHttpMessageNotReadable(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new NotFoundResponse<>(new ErrMessage(ex.getLocalizedMessage())), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    protected ResponseEntity<NotFoundResponse<ErrMessage>> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new NotFoundResponse<>(new ErrMessage(ex.getLocalizedMessage())), HttpStatus.NOT_FOUND);
    }

}
