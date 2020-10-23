package com.algaworks.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.model.OrderofService;

@Repository
public interface OrderofServiceRepository extends JpaRepository<OrderofService, Long>{

	
	
}
