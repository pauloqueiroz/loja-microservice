package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.form.CompraForm;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public void realizaCompra(CompraForm compra) {
		InfoFornecedorDto infoFornecedor = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		System.out.println(infoFornecedor.getEndereco());
	}


	
}
