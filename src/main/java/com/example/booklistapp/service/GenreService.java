package com.example.booklistapp.service;
import com.example.booklistapp.dto.BookDTO;
import com.example.booklistapp.model.Genre;
import com.example.booklistapp.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.modelmapper.ModelMapper;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    private ModelMapper mapper;

    public List<BookDTO> getBooks(Long id){
        Genre genre = genreRepository.getReferenceById(id);

        return genre.getBookSet().stream().map(
                book -> {
                    BookDTO bookDTO = mapper.map(book, BookDTO.class);
                    String author = book.getAuthor().getName();
                    bookDTO.setAuthor(author);
                    bookDTO.setGenres(book.getGenreSet().stream().map(g -> g.getName()).toList());
                    return bookDTO;
                }
        ).toList();
    }
}
