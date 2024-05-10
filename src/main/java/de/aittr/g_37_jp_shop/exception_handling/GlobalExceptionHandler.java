package de.aittr.g_37_jp_shop.exception_handling;

import de.aittr.g_37_jp_shop.exception_handling.exceptions.FourthTestException;
import de.aittr.g_37_jp_shop.exception_handling.exceptions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//third way exception handling = the most useful way

//plus -  we create a global exception handler that can catch exceptions in all the controllers at once,
//and we separate the exception handling logic from our main logic,
//in this case we make simplify support and adding new features to our app

//minus - not a big minus. this way doesn't suit for us if we need a different exception handling logic for the same
// exception in different cases
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e){
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(FourthTestException.class)
    public ResponseEntity<Response> handleException(FourthTestException e){
        Response response = new Response(e.getMessage(), e.getCause().getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }
}
