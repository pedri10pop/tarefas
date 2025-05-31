package com.pedro.tarefas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.serices.TarefasService;

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

}
