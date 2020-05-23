package com.github.springbootgraphql.service.datafetcher;

import com.github.springbootgraphql.model.Book;
import com.github.springbootgraphql.reposiory.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    private BookRepository bookRepository;

    @Autowired
    public BookDataFetcher(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findById(dataFetchingEnvironment
                .getArgument("id").toString()).orElse(null);
    }
}
