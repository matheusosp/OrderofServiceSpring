package com.algaworks.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.exception.BusinessException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClientRepository;

@Service
public class CreateClienteService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Cliente Create(Cliente cliente) {
		Cliente clienteExists = clientRepository.findByEmail(cliente.getEmail());
		
		if(clienteExists !=null && !clienteExists.equals(cliente) ) {
			throw new BusinessException("Email already exists");
		}
		return clientRepository.save(cliente);
	}
	
	public void delete(Long clienteId) {
		clientRepository.deleteById(clienteId);
	}
}
