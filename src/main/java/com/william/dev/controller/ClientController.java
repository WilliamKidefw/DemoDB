package com.william.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.dev.model.Client;
import com.william.dev.request.ClientRequest;
import com.william.dev.response.ClientResponse;
import com.william.dev.response.KpiResponse;
import com.william.dev.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService service;
	
	@PostMapping("/creacliente")
    public ResponseEntity<Object> postClient(@RequestBody ClientRequest objeto) {
		Client client = service.registerClient(objeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
	
	@GetMapping("/kpideclientes")
    public ResponseEntity<KpiResponse> getAverage() {
		KpiResponse response = service.getAverage();
		return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	@GetMapping("/listclientes")
    public ResponseEntity<List<ClientResponse>> getClient() {
		List<ClientResponse> clients = service.getListClient();
		return ResponseEntity.status(HttpStatus.OK).body(clients);
    }
}
