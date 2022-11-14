package com.ratana.jfx.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String id) {
        super(String.format("The %s was not found with id= %s", resourceName, id));
    }

    public ResourceNotFoundException(String resourceName, String field, String id) {
        super(String.format("The %s was not found with %s = %s", resourceName, field, id));
    }
}
