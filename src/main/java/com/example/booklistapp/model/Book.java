package com.example.booklistapp.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Annotations for Lombok
    @Entity
    @Table(name = "`Book`")
    @Getter
    @Setter
    @EntityListeners(AuditingEntityListener.class)


    public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @NotBlank
        private String title;

        @NotNull
        @NotBlank
        @Min(value = 0)
        @Max(value = Integer.MAX_VALUE)
        private int pages;

        @Temporal(TemporalType.DATE)
        private Date published;

        @ManyToMany(mappedBy = "bookSet")
        private Set<ReadingList> readingSet = new HashSet<ReadingList>();

        @ManyToMany(mappedBy = "bookSet")
        private Set<Genre> genreSet = new HashSet<Genre>();

        @ManyToOne
        @JoinColumn(name = "author_id")
        //@OnDelete(action = OnDeleteAction.CASCADE)
        private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", published=" + published +
                ", readingSet=" + readingSet +
                ", genreSet=" + genreSet +
                ", author=" + author +
                '}';
    }
}

