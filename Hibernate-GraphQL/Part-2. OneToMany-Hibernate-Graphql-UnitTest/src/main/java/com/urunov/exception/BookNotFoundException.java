package com.urunov.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is Graphql-Unittest
 */

public class BookNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extentions = new HashMap<>();

    public BookNotFoundException(String message, Long invalidBookId){
        super(message);
        extentions.put("invalidBookId", invalidBookId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extentions;
    }

}
