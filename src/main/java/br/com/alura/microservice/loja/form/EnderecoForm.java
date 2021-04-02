package br.com.alura.microservice.loja.form;

public class EnderecoForm {

	private String rua;
	
	private String numero;
	
	private String estado;
	
	@Override
	public String toString() {
		return this.rua +", "+this.numero + " - "+this.estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
