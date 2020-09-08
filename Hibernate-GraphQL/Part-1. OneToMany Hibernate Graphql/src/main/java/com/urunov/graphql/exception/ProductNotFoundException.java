package com.urunov.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 08/09/2020
 * @Project is OnetoMany
 */


public class ProductNotFoundException extends RuntimeException implements GraphQLError {

   private Map<String, Object> extentions = new HashMap<>();

   public ProductNotFoundException(String message, Integer invalidProductId){
       super(message);
       extentions.put("invalid Product ID", invalidProductId);
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
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extentions;
    }
}
