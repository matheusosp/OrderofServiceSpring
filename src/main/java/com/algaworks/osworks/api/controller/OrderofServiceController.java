package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.api.model.ModelOrderofService;
import com.algaworks.osworks.api.model.OrderServiceinput;
import com.algaworks.osworks.domain.model.OrderofService;
import com.algaworks.osworks.domain.repository.OrderofServiceRepository;
import com.algaworks.osworks.domain.service.WorkOrderManagement;

@RestController
@RequestMapping("/Order")
public class OrderofServiceController {

	@Autowired
	private WorkOrderManagement Ordermanagement;
	
	@Autowired
	private OrderofServiceRepository order;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ModelOrderofService Create(@Valid @RequestBody OrderServiceinput orderInput) {
		OrderofService orderService = toEntity(orderInput);
		
		return toModel(Ordermanagement.Create(orderService));
		
	}
	
	@GetMapping
	public List<ModelOrderofService> list (){
		
		return toCollectionModel(order.findAll());
		
	}
	
	@GetMapping("/{orderofServiceId}")
	public ResponseEntity<ModelOrderofService> find(@PathVariable Long orderofServiceId){
		Optional<OrderofService> orderofService = order.findById(orderofServiceId);
		
		if(orderofService.isPresent()) {
			ModelOrderofService model = toModel(orderofService.get());

			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{orderServiceId}/finalization")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalization(@PathVariable Long orderServiceId) {
		Ordermanagement.finalization(orderServiceId);
	}
	
	private ModelOrderofService toModel(OrderofService orderService) {
		
		return modelMapper.map(orderService, ModelOrderofService.class);
		
	}
	
	private List <ModelOrderofService> toCollectionModel(List<OrderofService> ordersService){
		
		return ordersService.stream().map(OrderofService -> toModel(OrderofService)).collect(Collectors.toList());
		
	}
	
	private OrderofService toEntity(OrderServiceinput orderServiceInput) {
		return modelMapper.map(orderServiceInput, OrderofService.class);
	}
	
} 
