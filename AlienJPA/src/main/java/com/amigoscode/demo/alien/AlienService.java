package com.amigoscode.demo.alien;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlienService {
	
	private AlienRepo aRepo;

	@Autowired
	public AlienService(AlienRepo aRepo) {
		super();
		this.aRepo = aRepo;
	}
	
	public List<Alien> getAlien(){
		
		return aRepo.findAll();
	}

	public void addAlien(Alien alien) {
		
		Optional<Alien> findEmail = aRepo.findAlienByemail(alien.getEmail());
		if(findEmail.isPresent()) {
			
			throw new IllegalStateException("Email already exists");
		}
		
		aRepo.save(alien);
	}

	public void deleteAlien(long id) {

		boolean existsId = aRepo.existsById(id);
		if( !existsId ) {
			
			throw new IllegalStateException("Alien Id " +id+ " does not exists");
			
		}
		
		aRepo.deleteById(id);
		
	}
	@Transactional
	public void updateAlien(long id, String name, String email) {
		
		Alien alien = aRepo.findById(id).orElseThrow(
				() -> new IllegalStateException("Id "+id+" does not exists")
				);
		if( name != null && name.length() > 0 && !Objects.equals(alien.getName(), name) ) {
			
			alien.setName(name);
		}
		
		if( email != null && email.length() > 0 && !Objects.equals(alien.getEmail(), email) ) {
			
			Optional<Alien> findEmail = aRepo.findAlienByemail(email);
			if(findEmail.isPresent()) {
				throw new IllegalStateException("Email already exists");
			}
			
			alien.setEmail(email);
		}
	}

		
	}


