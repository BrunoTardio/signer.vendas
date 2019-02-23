package com.signer.vendas;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.repository.ClienteEnderecoRepository;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRGRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.service.ClienteService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ProdutoCategoriaRepository pcrepo;

	@Autowired
	ClienteService cservice;

	@Autowired
	ClienteRepository crepo;

	@Autowired
	ClientePJRepository cpjrepo;

	@Autowired
	ClientePFRepository cpfrepo;
	
	@Autowired
	ClienteRGRepository crgrepo;
	
	@Autowired
	ClienteEleitorRepository cerepo;
	
	@Autowired
	ClienteEnderecoRepository cendrepo;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ProdutoCategoria pc1 = new ProdutoCategoria(null, "CD");
		ProdutoCategoria pc2 = new ProdutoCategoria(null, "PEN DRIVE");
		ProdutoCategoria pc3 = new ProdutoCategoria(null, "MIDIA DIGITAL");
		pcrepo.saveAll(Arrays.asList(pc1, pc2, pc3));

		Cliente c1 = new Cliente(null, "brunotardio@gmail.com", "123");
		Cliente c2 = new Cliente(null, "tardio@gmail.com", "123");
		Cliente c3 = new Cliente(null, "fernando@gmail.com", "123");
		Cliente c4 = new Cliente(null, "gustavo@gmail.com", "123");
		Cliente c5 = new Cliente(null, "bruno@gmail.com", "123");
		
		Set<String> telefones = new HashSet<>();
		telefones.add("32991612896");
		telefones.add("32999998888");
		Set<String> emails = new HashSet<>();
		emails.add("brunotardio@gmail.com");
		emails.add("brunotardio89@gmail.com");
		emails.add("barbosasilverio89@gmail.com");	
		c1.setTelefones(telefones);
		c1.setEmails(emails);
		crepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

		ClientePJ cpj1 = new ClientePJ(null, "TardioTEC", "Tardio aplicacoes", "44777799595", "9600600", "mei", c1);
		ClientePJ cpj2 = new ClientePJ(null, "TardioTEC 02 ", "Tardio websites", "65656005", "9322200", "simples", c1);
		ClientePJ cpj3 = new ClientePJ(null, "Limtda", "Gustavo mecanico", "000651050", "4444444", "eirele", c4);
		cpjrepo.saveAll(Arrays.asList(cpj1, cpj2, cpj3));

		ClientePF cpf1 = new ClientePF(null, "Bruno Tardio", "0907777777", "16/08/1990" , "1910509", "1515", c1);
		ClientePF cpf2 = new ClientePF(null, "Augosto Silva", "865656555", "16/08/1990", "191919", "1015", c2);
		ClientePF cpf3 = new ClientePF(null, "Marcelo Divino", "090770007", "16/08/1990", "0013319", "1512", c3);		
		cpfrepo.saveAll(Arrays.asList(cpf1, cpf2, cpf3));
		
		ClienteRG crg1 = new ClienteRG(null, "Bruno Tardio","0000", "16", "ssp","elias","cristiane", cpf1);
		crgrepo.save(crg1);
		
		ClienteEleitor ce1 = new ClienteEleitor(null, "300", "jardim", "153","juiz de fora", "mg", cpf1);
		cerepo.save(ce1);
		
		ClienteEndereco cend1 = new ClienteEndereco(null, "Rua guilardo", "200", "Casa", "Milho branco", "360000", "Juiz de fora", "mg", cpf1, cpj1);
		ClienteEndereco cend2 = new ClienteEndereco(null, "Eulices", "200", "ap 01", "Milho preto", "360000", "Juiz de fora", "mg", null, cpj2);
		cendrepo.saveAll(Arrays.asList(cend1,cend2));

	}


	
	

}
