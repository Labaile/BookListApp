package com.example.booklistapp.repository;
import com.example.booklistapp.model.User;
import com.example.booklistapp.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {
    ReadingList findByNameAndUser(String name, User user);
    List<ReadingList> findByUser(User user);
}