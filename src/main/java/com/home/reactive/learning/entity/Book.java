package com.home.reactive.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @Column("book_id")
    private  int bookId;

    private  String name;

    @Column("book_desc")
    private  String description;

    private  String publisher;

    private  String author;


}
