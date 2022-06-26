package com.amigoscode.demo.alien;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlienConfig {
	
	private AlienRepo aRepo;

	@Autowired
	public AlienConfig(AlienRepo aRepo) {
		super();
		this.aRepo = aRepo;
	}
	
	@Bean
	CommandLineRunner cmdRunner() {
		
		return args->{
			
			Alien a1 =new Alien("Harry","h@gmail.com",LocalDate.of(1998, 04, 05),54);
			Alien a2 =new Alien("David","d@gmail.com",LocalDate.of(1998, 04, 05),54);
			
			aRepo.saveAll(List.of(a1,a2));
			
		};
		
	}
	

}
