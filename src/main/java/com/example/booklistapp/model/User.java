package com.example.booklistapp.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//Annotations for Lombok
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//Javax persistence
// Added Auditing Entity from spring data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String password;

}
