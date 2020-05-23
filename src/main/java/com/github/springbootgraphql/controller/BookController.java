package com.github.springbootgraphql.controller;

import com.github.springbootgraphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private GraphQLService graphQLService;

    @Autowired
    public BookController(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }


    @PostMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody String query) {

        ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}
