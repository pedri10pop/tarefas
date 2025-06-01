package com.pedro.tarefas.serices;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.pedro.tarefas.exception.RecordNotFoundException;
import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.repository.TarefasRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class TarefasService {

    private final TarefasRepository tarefaRepository;

    public TarefasService(TarefasRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa create(@Valid Tarefa tarefa) {
        if (tarefa.getStatus() == null || tarefa.getStatus().isEmpty()) {
            tarefa.setStatus("To Do");
        }
        return tarefaRepository.save(tarefa);
    }

    public Tarefa findById(@NotNull @Positive Long id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Tarefa update(@NotNull @Positive Long id, @Valid Tarefa tarefa) {
        return tarefaRepository.findById(id)
                .map(existingTarefa -> {
                    existingTarefa.setTitle(tarefa.getTitle());
                    existingTarefa.setDescription(tarefa.getDescription());
                    existingTarefa.setStatus(tarefa.getStatus());
                    return tarefaRepository.save(existingTarefa);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {

        tarefaRepository.delete(tarefaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

    }

}
