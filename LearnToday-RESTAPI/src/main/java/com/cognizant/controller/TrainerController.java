package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dao.TrainerDao;
import com.cognizant.model.Trainer;
import com.cognizant.service.TrainerService;

@RestController
public class TrainerController {
	@Autowired
	TrainerService trainerService;

	@PostMapping("/trainer")
	public ResponseEntity<Object> trainerSignUp(@RequestBody Trainer trainer) {
		if (trainerService.save(trainer) == null) {
			return new ResponseEntity(trainer, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(trainer, HttpStatus.CREATED);

	}

	@PutMapping("/trainer/{id}")
	public ResponseEntity<Object> updatePassword(@PathVariable int id, @RequestBody String password) {
		if (trainerService.update(id, password) == null) {
			new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("Data updated successfully", HttpStatus.OK);
	}
}
