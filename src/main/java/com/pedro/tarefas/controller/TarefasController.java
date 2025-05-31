package com.pedro.tarefas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.tarefas.serices.TarefasService;

@RestController
@RequestMapping("api/tarefa")
public class TarefasController {

    private final TarefasService tarefaService;

    public TarefasController(TarefasService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Map<String, Object>> list() {
        return tarefaService.listAll();
    }

}
