package com.pedro.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.tarefas.model.Tarefa;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {

}