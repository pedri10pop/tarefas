package com.pedro.tarefas.dto.mapper;

import org.springframework.stereotype.Component;

import com.pedro.tarefas.dto.TarefaDTO;
import com.pedro.tarefas.enums.Status;
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
                tarefa.getStatus().toString());
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
        tarefa.setStatus(converterStatusValue(tarefaDTO.status()));
        return tarefa;
    }

    public static Status converterStatusValue(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "TO_DO":
                return Status.TO_DO;
            case "IN_PROGRESS":
                return Status.IN_PROGRESS;
            case "DONE":
                return Status.DONE;
            default:
                throw new IllegalArgumentException("Unknown status: " + value);
        }
    }

}
