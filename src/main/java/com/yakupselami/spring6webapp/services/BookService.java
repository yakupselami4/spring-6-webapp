package com.yakupselami.spring6webapp.services;

import com.yakupselami.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
