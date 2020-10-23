package com.algaworks.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.api.model.Comment;
import com.algaworks.osworks.domain.exception.BusinessException;
import com.algaworks.osworks.domain.exception.EntityIdCommentNotFoundException;
import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.OrderofService;
import com.algaworks.osworks.domain.model.StatusOrder;
import com.algaworks.osworks.domain.repository.ClientRepository;
import com.algaworks.osworks.domain.repository.CommentRepository;
import com.algaworks.osworks.domain.repository.OrderofServiceRepository;

@Service
public class WorkOrderManagement {

	@Autowired
	private OrderofServiceRepository orderofServiceRepository;
	
	@Autowired
	private ClientRepository clienteRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public OrderofService Create(OrderofService order) {
		Cliente cliente = clienteRepository.findById(order.getCliente().getId()).orElseThrow(() -> new BusinessException("Cliente not found"));
		
		order.setCliente(cliente);
		order.setStatus(StatusOrder.Open); 
		order.setDataOpening(OffsetDateTime.now()); 
		
		return orderofServiceRepository.save(order);
	}
	
	public void finalization(Long orderServiceId) {
		
		OrderofService orderService = buscar(orderServiceId);
		if(!StatusOrder.Open.equals(orderService.getStatus())) {
			throw new BusinessException("Order cannot be finalized");
		}
		
		orderService.setStatus(StatusOrder.Finished );
		orderService.setDataFinalization(OffsetDateTime.now());
		orderofServiceRepository.save(orderService);
	}
	public Comment addComment(Long orderofServiceId, String description) {
		OrderofService orderService = buscar(orderofServiceId);
		
		Comment comment = new Comment();
		comment.setDataSend(OffsetDateTime.now());
		comment.setDescription(description);
		comment.setOrderService(orderService);
		
		return commentRepository.save(comment);
	}

	private OrderofService buscar(Long orderofServiceId) {
		return orderofServiceRepository.findById(orderofServiceId).orElseThrow(() -> new EntityIdCommentNotFoundException("Order Not Found"));
	}
	
}
