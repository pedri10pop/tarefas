package com.pedro.tarefas.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 256, nullable = false)
    private String title;

    @Column(length = 1024)
    private String description;

    @Column(length = 20, nullable = false)
    private String status;

    @CreatedDate
    private Date creationDate;
}
