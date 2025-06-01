package com.pedro.tarefas.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TarefaDTO(
        Long id,
        @NotNull @NotBlank @Length(max = 256) String title,
        @Column(length = 1024) String description,
        @NotNull @NotBlank @Length(max = 20) @Pattern(regexp = "^(To Do|In Progress|Done)$", message = "Status must be one of: To Do, In Progress, Done") String status) {

}
