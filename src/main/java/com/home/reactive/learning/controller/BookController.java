package com.home.reactive.learning.controller;

import com.home.reactive.learning.entity.Book;
import com.home.reactive.learning.service.BookService;
import com.home.reactive.learning.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    //    create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookServiceImpl.create(book);
    }

    //    get all books
    @GetMapping
    public Flux<Book> getAll() {
        return bookServiceImpl.getAll();
    }

    //    get single book
    @GetMapping("/{bid}")
    public Mono<Book> get(@PathVariable("bid") int bookId) {
        return bookServiceImpl.get(bookId);
    }

    //    update
    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int bookId) {
        return bookServiceImpl.update(book, bookId);
    }

    //    delete
    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId) {
        return bookServiceImpl.delete(bookId);
    }

//    search

    @GetMapping("/search")
    public Flux<Book> searchBooks(
            @RequestParam("query") String query
    ) {
        System.out.println(query);
        return this.bookServiceImpl.searchBooks(query);
    }

}
