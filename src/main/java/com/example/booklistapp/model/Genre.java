package com.example.booklistapp.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

//Annotations for Lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//Javax persistence?
//Auditing Entity is from spring data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "`Genre`")

public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(
            name = "Genre_Books",
            joinColumns = {@JoinColumn(name = "genre_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private Set<Book> bookSet = new HashSet<Book>();

}

