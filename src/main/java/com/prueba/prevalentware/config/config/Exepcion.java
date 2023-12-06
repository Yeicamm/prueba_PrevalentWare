package com.prueba.prevalentware.config.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class Exepcion extends RuntimeException{
    public Exepcion (String mensaje){
        super(mensaje);
    }
}
