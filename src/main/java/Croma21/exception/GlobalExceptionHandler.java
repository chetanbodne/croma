package Croma21.exception;

import Croma21.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> HandlerResourceNotFoundException(ResourceNotFound ex) {
        // return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorDetails err = new ErrorDetails(ex.getMessage(), new Date());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> HandlerResourceNotFoundException(Exception ex) {
        //  return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorDetails err = new ErrorDetails(ex.getMessage(), new Date());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
