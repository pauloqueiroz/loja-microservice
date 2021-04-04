package br.com.alura.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.form.CompraForm;
import br.com.alura.microservice.loja.model.Compra;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService service;

	@RequestMapping(method = RequestMethod.POST)
	public Compra realizaCompra(@RequestBody CompraForm compra) {
		return service.realizaCompra(compra);
	}
}
