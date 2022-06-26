package com.amigoscode.demo.alien;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Long>{
	
	@Query("select a from Alien a where a.email=?1")
	Optional<Alien> findAlienByemail(String email);

}
