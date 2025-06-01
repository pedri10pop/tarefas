package com.pedro.tarefas.serices;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.pedro.tarefas.dto.TarefaDTO;
import com.pedro.tarefas.dto.mapper.TarefaMapper;
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
    private final TarefaMapper tarefaMapper;

    public TarefasService(TarefasRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> listAll() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(tarefaMapper::toDTO)
                .toList();
    }

    public TarefaDTO create(@Valid @NotNull TarefaDTO tarefa) {

        Tarefa tarefaEntity = tarefaMapper.toEntity(tarefa);

        if (tarefaEntity.getStatus() == null || tarefaEntity.getStatus().isEmpty()) {
            tarefaEntity.setStatus("To Do");
        }
        return tarefaMapper.toDTO(tarefaRepository.save(tarefaEntity));
    }

    public TarefaDTO findById(@NotNull @Positive Long id) {
        return tarefaRepository.findById(id).map(tarefaMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public TarefaDTO update(@NotNull @Positive Long id, @Valid @NotNull TarefaDTO tarefa) {
        return tarefaRepository.findById(id)
                .map(existingTarefa -> {
                    existingTarefa.setTitle(tarefa.title());
                    existingTarefa.setDescription(tarefa.description());
                    existingTarefa.setStatus(tarefa.status());
                    return tarefaRepository.save(existingTarefa);
                }).map(tarefaMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {

        tarefaRepository.delete(tarefaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

    }

}
