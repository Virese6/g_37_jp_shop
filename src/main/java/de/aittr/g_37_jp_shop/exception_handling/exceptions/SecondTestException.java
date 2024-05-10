package de.aittr.g_37_jp_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//second way exception handling

//plus - we can fast and comfortable without extra code create a global exception handler

//minus - the client don't see a detailing error message, so we can't handle it
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class SecondTestException extends  RuntimeException{
    public SecondTestException(String message) {
        super(message);
    }
}
