package com.pedro.tarefas.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @Length(max = 256)
    private String title;

    @Column(length = 1024)
    private String description;

    @NotNull
    @NotBlank
    @Length(max = 20)
    @Pattern(regexp = "^(To Do|In Progress|Done)$", message = "Status must be one of: To Do, In Progress, Done")
    private String status;

    @CreatedDate
    private Date creationDate;
}
