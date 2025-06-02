package com.pedro.tarefas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.pedro.tarefas.enums.Status;
import com.pedro.tarefas.model.Tarefa;
import com.pedro.tarefas.repository.TarefasRepository;

@SpringBootApplication
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(TarefasRepository tarefasRepository) {
		return args -> {
			tarefasRepository.deleteAll();

			Tarefa t = new Tarefa();

			t.setTitle("First Year Task");
			t.setDescription("Test string for task");
			t.setStatus(Status.TO_DO);

			Tarefa t2 = new Tarefa();

			t2.setTitle("Second Year Task");
			t2.setDescription("Test content");
			t2.setStatus(Status.IN_PROGRESS);

			Tarefa t3 = new Tarefa();

			t3.setTitle("Third Year Task");
			t3.setDescription("Test long content for task, this is a test string to check the length of the description field in the database.");
			t3.setStatus(Status.DONE);

			Tarefa t4 = new Tarefa();

			t4.setTitle("Fourth Year Task");
			t4.setDescription("Test fourth task description, this is a test string to check the length of the description field in the database.");
			t4.setStatus(Status.DONE);

			tarefasRepository.save(t);
			tarefasRepository.save(t2);
			tarefasRepository.save(t3);
			tarefasRepository.save(t4);
		};
	}

}
