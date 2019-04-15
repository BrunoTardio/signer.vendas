package com.signer.vendas;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.signer.vendas.domain.Cliente;
import com.signer.vendas.domain.ClienteEleitor;
import com.signer.vendas.domain.ClienteEndereco;
import com.signer.vendas.domain.ClientePF;
import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.ClienteRG;
import com.signer.vendas.domain.Pedido;

import com.signer.vendas.domain.Produto;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.domain.enums.EstadoPagamento;
import com.signer.vendas.domain.enums.EstadoPedido;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.repository.ClienteEnderecoRepository;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRGRepository;
import com.signer.vendas.repository.ClienteRepository;

import com.signer.vendas.repository.PedidoRepository;

import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.repository.ProdutoRepository;
import com.signer.vendas.service.ClienteService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
