package com.example.booklistapp.controller.api;

import com.example.booklistapp.dto.BookDTO;
import com.example.booklistapp.dto.CreateBookDTO;
import com.example.booklistapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public String getTest(){
        return "books";
    }

    @PostMapping
    public BookDTO createBook(@RequestBody CreateBookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }


}