package com.elciosantos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elciosantos.domain.Categoria;
import com.elciosantos.respositories.CategoriaRepository;
import com.elciosantos.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository _repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = _repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
