package com.pedro.tarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.tarefas.dto.TarefaDTO;
import com.pedro.tarefas.enums.Status;
import com.pedro.tarefas.serices.TarefasService;

import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
@RestController
@RequestMapping("api/tarefa")
public class TarefasController {

    private final TarefasService tarefaService;

    public TarefasController(TarefasService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Operation(summary = "Listar todas as tarefas", description = "Retorna uma lista de tarefas. É possível filtrar por um ou mais status.")
    @GetMapping
    public List<TarefaDTO> list(
            @RequestParam(name = "status", required = false) List<Status> statuses) {
        return tarefaService.listAll(statuses);
    }

    @Operation(summary = "Buscar tarefa por ID", description = "Retorna uma tarefa específica pelo seu identificador.")
    @GetMapping("/{id}")
    public TarefaDTO findById(@PathVariable @NotNull @Positive Long id) {
        return tarefaService.findById(id);
    }

    @Operation(summary = "Criar nova tarefa", description = "Cria uma nova tarefa a partir do DTO fornecido.")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TarefaDTO create(@RequestBody @Valid @NotNull TarefaDTO tarefa) {
        return tarefaService.create(tarefa);
    }

    @Operation(summary = "Atualizar tarefa existente", description = "Atualiza os campos de uma tarefa pelo seu ID.")
    @PutMapping("/{id}")
    public TarefaDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull TarefaDTO tarefa) {
        return tarefaService.update(id, tarefa);
    }

    @Operation(summary = "Remover tarefa", description = "Deleta uma tarefa existente pelo seu ID.")
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        tarefaService.delete(id);
    }

}
