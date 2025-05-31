package com.pedro.tarefas.serices;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.repository.TarefasRepository;

@Service
public class TarefasService {

    private final TarefasRepository tarefaRepository;

    public TarefasService(TarefasRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listAll() {
        return tarefaRepository.findAll();
    }

}
