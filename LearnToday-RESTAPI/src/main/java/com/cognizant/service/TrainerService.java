package com.cognizant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.model.Trainer;
import com.cognizant.repository.TrainerRepository;

@Component
public class TrainerService {
	@Autowired
	TrainerRepository trainerRepo;

	public Trainer save(Trainer trainer) {
		return trainerRepo.saveAndFlush(trainer);
	}

	public Optional<Trainer> update(int id, String password) {
		Optional<Trainer>trainer = trainerRepo.findById(id);
		if(trainer == null) {
			return null;
		}
		trainer.get().setPassword(password);
		return trainer;
	}
}
