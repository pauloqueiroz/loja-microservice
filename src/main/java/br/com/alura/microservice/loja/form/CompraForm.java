package br.com.alura.microservice.loja.form;

import java.util.List;

public class CompraForm {

	private List<ItemDaCompraForm> itens;
	
	private EnderecoForm endereco;
	
	@Override
	public String toString() {
		return this.itens.size() + endereco.toString();
	}

	public List<ItemDaCompraForm> getItens() {
		return itens;
	}

	public void setItens(List<ItemDaCompraForm> itens) {
		this.itens = itens;
	}

	public EnderecoForm getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoForm endereco) {
		this.endereco = endereco;
	}
}
