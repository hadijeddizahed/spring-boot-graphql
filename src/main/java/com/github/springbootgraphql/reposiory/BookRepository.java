package com.github.springbootgraphql.reposiory;

import com.github.springbootgraphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
