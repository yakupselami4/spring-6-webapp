package com.yakupselami.spring6webapp.services;

import com.yakupselami.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
