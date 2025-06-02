package com.pedro.tarefas.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TarefaDTO(
        Long id,
        @NotNull @NotBlank @Length(max = 256) String title,
        @Column(length = 1024) String description,
        @NotNull @NotBlank @Length(max = 20) @Pattern(regexp = "^(TO_DO|IN_PROGRESS|DONE)$", message = "Status must be one of: TO_DO,IN_PROGRESS,DONE") String status,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime creationDate) {

}
