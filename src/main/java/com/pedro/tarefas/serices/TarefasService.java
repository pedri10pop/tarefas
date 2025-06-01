package com.pedro.tarefas.serices;

import java.util.List;
import java.util.Optional;

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

    public Tarefa create(Tarefa tarefa) {
        if (tarefa.getStatus() == null || tarefa.getStatus().isEmpty()) {
            tarefa.setStatus("To Do");
        }
        return tarefaRepository.save(tarefa);
    }

    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa update(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);

    }

    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }

}
