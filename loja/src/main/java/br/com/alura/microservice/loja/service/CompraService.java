package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClint;

	public void realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info = fornecedorClint.getInfoPorEstado(compra.getEndereco().getEstado());
		System.out.println(info.getEndereco());

	}

}
