package com.william.dev.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.william.dev.model.Client;
import com.william.dev.repository.IClientRepository;
import com.william.dev.request.ClientRequest;
import com.william.dev.response.ClientResponse;
import com.william.dev.response.KpiResponse;
import com.william.dev.service.IClientService;
import com.william.dev.util.Utils;

@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private IClientRepository repoClient;
	

	@Override
	public Client registrar(Client obj) {
		return repoClient.save(obj);
	}


	@Override
	public Client modificar(Client obj) {
		return repoClient.save(obj);
	}


	@Override
	public List<Client> listar() {
		return repoClient.findAll();
	}


	@Override
	public Client listarPorId(Integer id) {
		Optional<Client> op = repoClient.findById(id);
		return op.isPresent() ? op.get() : new Client();
	}


	@Override
	public boolean eliminar(Integer id) {
		repoClient.deleteById(id);
		return true;
	}


	@Override
	public Client registerClient(ClientRequest obj) {
		Client client = new Client();
		client.setNombre(obj.getNombre());
		client.setApellido(obj.getApellido());
		client.setEdad(obj.getEdad());
		client.setFecNacimiento(obj.getFechaNacimiento());
		return repoClient.save(client);
	}


	@Override
	public KpiResponse getAverage() {
		List<Client> clients = repoClient.findAll();
		double average = clients.stream().collect(Collectors.averagingInt(Client::getEdad));
		double standarDesviation = calculateSD(clients,average);
		KpiResponse response = new KpiResponse();
		response.setAverage(average);
		response.setStandardDeviation(standarDesviation);
		return response;
	}
	
	public double calculateSD(List<Client> clients,double average) {	
		double varianza = clients.stream().mapToDouble(c-> Math.pow(c.getEdad()-average, 2)).sum();
		varianza = varianza / clients.size()-1;
		return Math.sqrt(varianza);
    }


	@Override
	public List<ClientResponse> getListClient() {
		List<Client> clientes = repoClient.findAll();
		return clientes.stream().
				map(c-> {
					ClientResponse response = new ClientResponse();
					response.setNombre(c.getNombre());
					response.setApellido(c.getApellido());
					response.setEdad(c.getEdad());
					response.setFechaNacimiento(c.getFecNacimiento());
					response.setFechaMuerte(c.getFecNacimiento().plusDays(Utils.randomNumbers()));
					return response;
					}).collect(Collectors.toList());
	}

}
