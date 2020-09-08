package com.urunov.graphql.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is OnetoMany
 */
public class GraphQLErrorAdapter implements GraphQLError {
    private GraphQLError error;

    @Override
    public String getMessage() {
        return error.getMessage();
    }

    @JsonIgnore
    @Override
    public List<SourceLocation> getLocations() {
        return error.getLocations();
    }

    @JsonIgnore
    @Override
    public ErrorType getErrorType() {
        return error.getErrorType();
    }

    @JsonIgnore
    @Override
    public List<Object> getPath() {
        return error.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return error.toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return error.getExtensions();
    }
}
