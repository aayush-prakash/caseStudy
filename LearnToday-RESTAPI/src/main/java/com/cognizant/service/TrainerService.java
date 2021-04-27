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

	
}
