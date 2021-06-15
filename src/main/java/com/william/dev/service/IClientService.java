package com.william.dev.service;

import java.util.List;

import com.william.dev.model.Client;
import com.william.dev.request.ClientRequest;
import com.william.dev.response.ClientResponse;
import com.william.dev.response.KpiResponse;

public interface IClientService extends ICRUD<Client, Integer>{

	Client registerClient(ClientRequest obj);
	KpiResponse getAverage();
	List<ClientResponse> getListClient();
}
