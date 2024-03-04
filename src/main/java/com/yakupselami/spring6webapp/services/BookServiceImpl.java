package com.yakupselami.spring6webapp.services;

import com.yakupselami.spring6webapp.domain.Book;
import com.yakupselami.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
