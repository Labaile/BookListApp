package com.example.booklistapp.repository;

import com.example.booklistapp.model.Author;
import com.example.booklistapp.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}