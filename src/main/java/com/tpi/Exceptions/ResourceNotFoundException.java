package com.tpi.Exceptions;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}