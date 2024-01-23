package com.home.reactive.learning.service;

import com.home.reactive.learning.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    public Mono<Book> create(Book book);

    public Flux<Book> getAll();

    public Mono<Book> get(int bookId);

    public Mono<Book> update(Book book, int bookId);

    public Mono<Void> delete(int bookId);

    public Flux<Book> search(String query);

//    add more methods are your requirement

    Flux<Book> searchBooks(String titleKeyword);
}
