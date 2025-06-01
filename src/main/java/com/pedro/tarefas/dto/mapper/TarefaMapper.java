package com.pedro.tarefas.dto.mapper;

import org.springframework.stereotype.Component;

import com.pedro.tarefas.dto.TarefaDTO;
import com.pedro.tarefas.model.Tarefa;

@Component
public class TarefaMapper {

    public TarefaDTO toDTO(Tarefa tarefa) {
        if (tarefa == null) {
            return null;
        }
        return new TarefaDTO(
                tarefa.getId(),
                tarefa.getTitle(),
                tarefa.getDescription(),
                tarefa.getStatus());
    }

    public Tarefa toEntity(TarefaDTO tarefaDTO) {
        if (tarefaDTO == null) {
            return null;
        }
        Tarefa tarefa = new Tarefa();
        if (tarefaDTO.id() != null) {
            tarefa.setId(tarefaDTO.id());
        }
        tarefa.setTitle(tarefaDTO.title());
        tarefa.setDescription(tarefaDTO.description());
        tarefa.setStatus(tarefaDTO.status());
        return tarefa;
    }

}
