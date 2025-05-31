package com.pedro.tarefas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.repository.TarefasRepository;

@SpringBootApplication
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(TarefasRepository tarefasRepository) {
		return args -> {
			tarefasRepository.deleteAll();

			Tarefa t = new Tarefa();

			t.setTitle("First Year Task");
			t.setDescription("Test string for task");
			t.setStatus("In Progress");

			tarefasRepository.save(t);
		};
	}

}
