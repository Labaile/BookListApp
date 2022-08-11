package com.example.booklistapp.dto;

import com.example.booklistapp.model.Genre;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class BookDTO {
    private String title;
    private int pages;
    private Date published;
    private String author;
    private List<String> genres;
}