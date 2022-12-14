package com.example.task;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EnableMongoRepositories
public class TaskApplication {

	@Autowired
	TaskRepository toDoRepository;


	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<Task> todos = List.of(
						Task.builder().created(LocalDateTime.now()).title("Securtiy Check").build(),
						Task.builder().title("Tests").created(LocalDateTime.now()).build(),
						Task.builder().title("Tutorial").created(LocalDateTime.now()).build());
				toDoRepository.saveAll(todos);
			}
		};
	}

}
