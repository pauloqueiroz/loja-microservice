package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.form.CompraForm;

@Service
public class CompraService {

	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private DiscoveryClient eurekaClient;

	public void realizaCompra(CompraForm compra) {
		ResponseEntity<InfoFornecedorDto> exchange = rest.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);
		
		imprimeInstanciasLoadBalancer();
		
		System.out.println(exchange.getBody().getEndereco());
	}

	private void imprimeInstanciasLoadBalancer() {
		eurekaClient.getInstances("fornecedor").stream().forEach(
				fornecedor->{
					System.out.println(fornecedor.getHost() + ":"+fornecedor.getPort()+" - "+fornecedor.getServiceId() + " - " +fornecedor.getInstanceId());
				});
		
	}

	
}
