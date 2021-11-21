package com.raman.notesapidateupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NotesApiDateUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApiDateUpdateApplication.class, args);
	}

}
