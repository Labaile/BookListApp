package com.example.booklistapp.controller.api;

import com.example.booklistapp.dto.BookDTO;
import com.example.booklistapp.dto.CreateBookDTO;
import com.example.booklistapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);}
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id, @RequestBody CreateBookDTO bookDTO){
        return bookService.updateBook(id,bookDTO);
    }

    @GetMapping
    public List<BookDTO> getBooks(){
        return bookService.getBooks();
    }
    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }
    @PostMapping
    public BookDTO createBook(@RequestBody CreateBookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }


}
