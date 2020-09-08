//package com.urunov.exception;
//
//import graphql.ExceptionWhileDataFetching;
//import graphql.GraphQLError;
//import graphql.servlet.DefaultGraphQLErrorHandler;
//import graphql.servlet.GenericGraphQLError;
//import graphql.servlet.GraphQLErrorHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Configuration
//public class GraphQLErrorHandlerConfig {
//
//    public static final Logger log = LoggerFactory.getLogger(DefaultGraphQLErrorHandler.class);
//
//    @Bean
//    public GraphQLErrorHandler errorHandler() {
//        return new GraphQLErrorHandler() {
//            @Override
//            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
//                List<GraphQLError> clientErrors = this.filterGraphQLErrors(errors);
//                if (clientErrors.size() < errors.size()) {
//                    clientErrors.add(new GenericGraphQLError("Internal Server Error(s) while executing query"));
//                    errors.stream().filter((error) -> {
//                        return !this.isClientError(error);
//                    }).forEach((error) -> {
//                        if (error instanceof Throwable) {
//                            log.error("Error executing query!", (Throwable)error);
//                        } else {
//                            log.error("Error executing query ({}): {}", error.getClass().getSimpleName(), error.getMessage());
//                        }
//
//                    });
//                }
//                return clientErrors;
//            }
//
//            private List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
//                return (List)errors.stream().filter(this::isClientError).map(GraphQLErrorAdapter::new).collect(Collectors.toList());
//            }
//
//            private boolean isClientError(GraphQLError error) {
//                if (error instanceof ExceptionWhileDataFetching) {
//                    return ((ExceptionWhileDataFetching)error).getException() instanceof GraphQLError;
//                } else {
//                    return !(error instanceof Throwable);
//                }
//            }
//        };
//    }
//}
