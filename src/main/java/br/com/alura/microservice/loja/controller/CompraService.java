package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.dto.InfoPedidoDto;
import br.com.alura.microservice.loja.form.CompraForm;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraForm compra) {
		InfoFornecedorDto infoFornecedor = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		InfoPedidoDto infoPedido = fornecedorClient.realizaPedido(compra.getItens());
		System.out.println(infoFornecedor.getEndereco());
		System.out.println(infoPedido);
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedido.getId());
		compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(infoFornecedor.getEndereco());
		return compraSalva;
	}


	
}
