package com.pedro.tarefas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.serices.TarefasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        return tarefaService.findById(id).map(tarefa -> ResponseEntity.ok().body(tarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return tarefaService.create(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.findById(id).map(updateTarefa -> {
            updateTarefa.setTitle(tarefa.getTitle());
            updateTarefa.setDescription(tarefa.getDescription());
            updateTarefa.setStatus(tarefa.getStatus());
            Tarefa updated = tarefaService.update(updateTarefa);
            return ResponseEntity.ok().body(updated);
        })
                .orElse(ResponseEntity.notFound().build());
    }

}
