package com.example.booklistapp.service;

import com.example.booklistapp.dto.BookDTO;
import com.example.booklistapp.dto.CreateBookDTO;
import com.example.booklistapp.model.Book;
import com.example.booklistapp.model.Genre;
import com.example.booklistapp.repository.AuthorRepository;
import com.example.booklistapp.repository.BookRepository;
import com.example.booklistapp.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    private ModelMapper mapper;
    public BookDTO createBook(CreateBookDTO bookDTO){
        Book book = mapper.map(bookDTO, Book.class);
        book.setAuthor(authorRepository.findByName(bookDTO.getAuthor()));
        Set<Genre> genreSet = book.getGenreSet();
        Book finalBook = book;
        bookDTO.getGenre().forEach(genreName -> {
            Genre genre = genreRepository.findByName(genreName);
            if(genre == null){
                genre = new Genre();
                genre.setName(genreName);
                genre.getBookSet().add(finalBook);
                genreRepository.save(genre);
            }
            genreSet.add(genre);
        });
        try{
            book = bookRepository.save(book);
        } catch( Exception e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"validation errors",e);
        }
        return mapper.map(book, BookDTO.class);
    }

}


