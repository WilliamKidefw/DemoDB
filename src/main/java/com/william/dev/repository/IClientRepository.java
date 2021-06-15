package com.william.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.william.dev.model.Client;

public interface IClientRepository extends JpaRepository<Client, Integer> {
	
	
}
