package me.dio.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<DetailsError> handleBusinessException(IllegalAccessException ex) {

        DetailsError error = new DetailsError(ex.getMessage());


        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<DetailsError> handleBusinessException() {

        DetailsError error = new DetailsError("Resorce id not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<DetailsError> handleUnexpectedException(Exception ex) {
        var mensage = "Unexpected server error,see the log";

        logger.error(mensage, ex);

        DetailsError error = new DetailsError(mensage);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
