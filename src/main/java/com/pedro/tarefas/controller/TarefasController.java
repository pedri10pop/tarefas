package com.pedro.tarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.serices.TarefasService;

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

    @GetMapping
    public List<Tarefa> list() {
        return tarefaService.listAll();
    }

    @GetMapping("/{id}")
    public Tarefa findById(@PathVariable @NotNull @Positive Long id) {
        return tarefaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tarefa create(@RequestBody @Valid Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Tarefa tarefa) {
        return tarefaService.update(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        tarefaService.delete(id);
    }

}
