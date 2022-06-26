package com.amigoscode.demo.alien;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/alien/")
public class AlienController {
	
	private AlienService aService;
	
	@Autowired
	public AlienController(AlienService aService) {
		super();
		this.aService = aService;
	}

	@GetMapping(path="/getAlien")
	public List<Alien> getAlien(){
		
		return aService.getAlien();
	}

	@PostMapping(path="/addAlien")
	public Alien addAlien(@RequestBody Alien alien) {
		
		aService.addAlien(alien);
		return alien;
	}
	
	@DeleteMapping(path="/deleteAlien/{id}")
	public void deleteAlien(@PathVariable ("id") long id) {
		
		
		aService.deleteAlien(id);
	}
	
	@PutMapping(path="/updateAlien/{id}")
	public void updateAlien(@PathVariable ("id") long id, 
							@RequestParam(required=false) String name, 
							@RequestParam(required=false) String email) {
		
		aService.updateAlien(id,name,email);
		
	}
}
