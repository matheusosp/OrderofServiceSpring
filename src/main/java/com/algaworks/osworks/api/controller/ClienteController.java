package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClientRepository;
import com.algaworks.osworks.domain.service.CreateClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClientRepository clienteRepository;
	
	@Autowired
	private CreateClienteService createClient;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente Create(@Valid @RequestBody Cliente cliente) {
		return createClient.Create(cliente);
	}
	
	@GetMapping
	public List<Cliente> Read() {
		return clienteRepository.findAll();	
	} 
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> Update(@Valid @PathVariable Long clienteId,@RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cliente = createClient.Create(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> Delete(@PathVariable Long clienteId) {
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		createClient.delete(clienteId);
		
		return ResponseEntity.noContent().build();
	}
		
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> find(@PathVariable Long clienteId) {
	
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
