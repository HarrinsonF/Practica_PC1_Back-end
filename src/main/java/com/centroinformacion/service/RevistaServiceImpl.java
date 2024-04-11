package com.centroinformacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centroinformacion.entity.Revista;
import com.centroinformacion.repository.RevistaRepository;

@Service
public class RevistaServiceImpl implements RevistaService{

	@Autowired
	private RevistaRepository repository;
	
	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		return repository.save(obj);
	}

	@Override
	public List<Revista> listaTodos() {
		return repository.findAll();
	}
	

}
