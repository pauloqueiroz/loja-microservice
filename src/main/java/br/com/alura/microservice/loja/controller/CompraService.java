package br.com.alura.microservice.loja.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.InfoFornecedorDto;
import br.com.alura.microservice.loja.dto.InfoPedidoDto;
import br.com.alura.microservice.loja.form.CompraForm;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraForm compra) {
		LOG.info("Realizando compra: "+ compra);
		InfoFornecedorDto infoFornecedor = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		LOG.info("Consultou fornecedor. Fornecedor retornado: "+infoFornecedor.getEndereco());
		InfoPedidoDto infoPedido = fornecedorClient.realizaPedido(compra.getItens());
		LOG.info("Realizou pedido. Pedido retornado: "+infoPedido.getId());

		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedido.getId());
		compraSalva.setTempoDePreparo(infoPedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(infoFornecedor.getEndereco());
		LOG.info("Salvou compra. "+compra.getEndereco());
		return compraSalva;
	}


	
}
