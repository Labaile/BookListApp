package com.example.booklistapp.repository;

import com.example.booklistapp.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

}