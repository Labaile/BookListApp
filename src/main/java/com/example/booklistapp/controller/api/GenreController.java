package com.example.booklistapp.controller.api;
import com.example.booklistapp.dto.BookDTO;
import com.example.booklistapp.service.BookService;
import com.example.booklistapp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")

public class GenreController {
    @Autowired
    GenreService genreService;


    @GetMapping("/{id}/books")
    public List<BookDTO> getBooks(@PathVariable Long id){
        return genreService.getBooks(id);
    }
    //@GetMapping
    //public String getTest(){
        //return "genre";
    //}

}