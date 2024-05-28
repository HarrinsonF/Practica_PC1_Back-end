package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.repository.EditorialRepository;

@Service
public class EditorialImp implements EditorialService{
	@Autowired
	private EditorialRepository repo;

	@Override
	public Editorial insertarEditorial(Editorial obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Editorial> listEditorial() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
