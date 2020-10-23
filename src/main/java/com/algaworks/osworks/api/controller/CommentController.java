package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.api.model.Comment;
import com.algaworks.osworks.domain.exception.EntityIdCommentNotFoundException;
import com.algaworks.osworks.domain.model.CommentInput;
import com.algaworks.osworks.domain.model.CommentModel;
import com.algaworks.osworks.domain.model.OrderofService;
import com.algaworks.osworks.domain.repository.OrderofServiceRepository;
import com.algaworks.osworks.domain.service.WorkOrderManagement;

@RestController
@RequestMapping("/Order/{orderServiceId}/Comment")
public class CommentController {

	@Autowired
	private WorkOrderManagement managementOrder;
	
	@Autowired
	private OrderofServiceRepository order;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping
	public List<CommentModel> listar(@PathVariable Long orderServiceId){
		OrderofService orderofService = order.findById(orderServiceId)
				.orElseThrow(() -> new EntityIdCommentNotFoundException("Order Not Found"));
		
		return toCollectionModel(orderofService.getComments());
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CommentModel addComment (@PathVariable Long orderServiceId,@RequestBody @Valid CommentInput commentInput) {
		
		Comment comment = managementOrder.addComment(orderServiceId, commentInput.getDescription());
		
		return toModel(comment);
	}
	
	private CommentModel toModel(Comment comment) {
		
		return modelMapper.map(comment, CommentModel.class);
		 
	}
	private List<CommentModel> toCollectionModel(List<Comment> comments) {
		
		return comments.stream().map(comment -> toModel(comment)).collect(Collectors.toList());
		
	}	
}
