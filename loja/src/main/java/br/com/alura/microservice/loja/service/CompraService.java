package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClint;

	public Compra realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info = fornecedorClint.getInfoPorEstado(compra.getEndereco().getEstado());

		InfoPedidoDTO pedido = fornecedorClint.realizaPedido(compra.getItens());

		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        
        return compraSalva;
	}

}
