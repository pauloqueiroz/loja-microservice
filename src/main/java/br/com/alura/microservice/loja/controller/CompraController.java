package br.com.alura.microservice.loja.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.loja.form.CompraForm;

@RestController
@RequestMapping("/compra")
public class CompraController {

	
	@RequestMapping(method = RequestMethod.POST)
	public void realizaCompra(@RequestBody CompraForm compra) {
		System.out.println(compra);
	}
}
