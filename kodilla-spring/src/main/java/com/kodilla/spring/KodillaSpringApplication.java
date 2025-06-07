package com.kodilla.spring;

import com.kodilla.spring.library.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KodillaSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(KodillaSpringApplication.class, args);

		Library library = context.getBean(Library.class);
		library.loadFromDb();
	}
}
