package com.yakupselami.spring6webapp.repositories;

import com.yakupselami.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
