package com.marcos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.cursomc.domain.Cliente;
import com.marcos.cursomc.repositories.ClienteRepository;
import com.marcos.cursomc.services.exceptions.ObjectNotFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	}
	
}
