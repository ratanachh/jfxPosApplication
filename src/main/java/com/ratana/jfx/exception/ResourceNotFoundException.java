package com.ratana.jfx.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String id) {
        super("The %s was not found with id= %s".formatted(resourceName, id));
    }
}
