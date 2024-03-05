package com.example.petmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.petmanagementsystem.model.Pet;
import com.example.petmanagementsystem.repository.PetRepository;
;



@RestController
public enum PetController {
	
	
	@Autowired
	PetRepository petrepository;
	
	
	
	@GetMapping("/petdata")
	public  List<Pet> pet() {
		return petrepository.findAll();
		}
	
	@PostMapping("/pet")
	public Pet createPetData(@RequestBody Pet data) {
		return petrepository.save(data);
	}
	

	@RequestMapping("/delete/{id}")
	public String deleteStud(@PathVariable int id) {
		petrepository.deleteById((long) id);
		return "Record Deleted";
	}
	
	@RequestMapping(path="Updated/{id}/{name}",method = RequestMethod.PUT)
	public String updateUser(@PathVariable Integer id , @PathVariable String name ) {
	 Pet pet=petrepository.findById(id);
	 //employee.setEmail(email);
	 pet.setName(name);
	 petrepository.save(pet);
	 return "Record Updated";
	}
	

}
