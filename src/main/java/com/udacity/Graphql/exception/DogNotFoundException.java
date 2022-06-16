package com.udacity.Graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException(String message, Long invalidId) {
        super(message);
        extensions.put("ivalidDogId", invalidId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }


    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
}
