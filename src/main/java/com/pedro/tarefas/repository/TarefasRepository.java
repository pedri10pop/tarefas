package com.pedro.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.tarefas.enums.Status;
import com.pedro.tarefas.model.Tarefa;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatusIn(List<Status> statuses);

}