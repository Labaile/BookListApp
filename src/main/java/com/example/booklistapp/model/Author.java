package com.example.booklistapp.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

//Annotations for Lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//Javax
//Auditing Entity is from spring data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "`Author`")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

}
