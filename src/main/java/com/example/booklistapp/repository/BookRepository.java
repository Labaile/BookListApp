package com.example.booklistapp.repository;
import com.example.booklistapp.model.Author;
import com.example.booklistapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleAndPagesAndAuthor(String title,int pages, Author author);
    Book findByTitleAndPages(String title,int pages);
    List<Book> findByTitle(String title);
}