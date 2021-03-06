package com.signer.vendas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
import com.signer.vendas.domain.enums.Perfil;
import com.signer.vendas.repository.ClienteEleitorRepository;
import com.signer.vendas.repository.ClienteEnderecoRepository;
import com.signer.vendas.repository.ClientePFRepository;
import com.signer.vendas.repository.ClientePJRepository;
import com.signer.vendas.repository.ClienteRGRepository;
import com.signer.vendas.repository.ClienteRepository;
import com.signer.vendas.repository.PedidoRepository;
import com.signer.vendas.repository.ProdutoCategoriaRepository;
import com.signer.vendas.repository.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	
	@Autowired
	PedidoRepository prepo;
	

	
	@Autowired
	ProdutoRepository prodrepo;
	
	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Cliente c1 = new Cliente(null, "brunotardio@gmail.com", pe.encode("12345678"));
		Cliente c2 = new Cliente(null, "tardio@gmail.com", pe.encode("12345678"));
		Cliente c3 = new Cliente(null, "fernando@gmail.com",pe.encode("12345678"));
		Cliente c4 = new Cliente(null, "gustavo@gmail.com", pe.encode("12345678"));
		Cliente c5 = new Cliente(null, "bru@gmail.com", pe.encode("12345678"));
		Cliente c6 = new Cliente(null, "bruno@gmail.com", pe.encode("12345678"));
		c6.addPerfil(Perfil.ADMIN);
		
		Set<String> telefones = new HashSet<>();
		telefones.add("32991612896");
		telefones.add("32999998888");
		Set<String> emails = new HashSet<>();
		emails.add("brunotardio@gmail.com");
		emails.add("brunotardio89@gmail.com");
		emails.add("barbosasilverio89@gmail.com");	
		c1.setTelefones(telefones);
		c1.setEmails(emails);
		crepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5,c6));

		ClientePJ cpj1 = new ClientePJ(null, "TardioTEC", "Tardio aplicacoes", "44777799595", "9600600", "mei", c1);
		ClientePJ cpj2 = new ClientePJ(null, "TardioTEC 02 ", "Tardio websites", "65656005", "9322200", "simples", c1);
		ClientePJ cpj3 = new ClientePJ(null, "Limtda", "Gustavo mecanico", "000651050", "4444444", "eirele", c4);
		cpjrepo.saveAll(Arrays.asList(cpj1, cpj2, cpj3));

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		
		ClientePF cpf1 = new ClientePF(null, "Bruno Tardio", "0907777777",sdf1.parse("21/02/2000") , "1910509", "1515", c1);
		ClientePF cpf2 = new ClientePF(null, "Augosto Silva", "865656555",sdf1.parse("21/02/1980")  , "191919", "1015", c2);
		ClientePF cpf3 = new ClientePF(null, "Marcelo Divino", "090770007",sdf1.parse("21/02/1990")  , "0013319", "1512", c3);		
		cpfrepo.saveAll(Arrays.asList(cpf1, cpf2, cpf3));
		
		ClienteRG crg1 = new ClienteRG(null, "Bruno Tardio","0000",sdf1.parse("21/02/2010"), "ssp","elias","cristiane", cpf1);
		crgrepo.save(crg1);
		
		ClienteEleitor ce1 = new ClienteEleitor(null, "300", "jardim", "153","juiz de fora", "mg", cpf1);
		cerepo.save(ce1);
		
		ClienteEndereco cend1 = new ClienteEndereco(null, "Rua guilardo", "200", "Casa", "Milho branco", "360000", "Juiz de fora", "mg", cpf1, null);
		ClienteEndereco cend2 = new ClienteEndereco(null, "Eulices", "200", "ap 01", "Milho preto", "360000", "Juiz de fora", "mg", null, cpj2);
		cendrepo.saveAll(Arrays.asList(cend1,cend2));
		
		////////////////////////////////////////////////
		
		ProdutoCategoria pc1 = new ProdutoCategoria(null, "CD");
		ProdutoCategoria pc2 = new ProdutoCategoria(null, "PEN DRIVE");
		ProdutoCategoria pc3 = new ProdutoCategoria(null, "MIDIA DIGITAL");
		pcrepo.saveAll(Arrays.asList(pc1, pc2, pc3));
		
		Produto prod1 = new Produto(null,"E-DIGITAL","CPF",pc1,180,90.0);
		Produto prod2 = new Produto(null,"E-CNPJ Certificado","CNPJ",pc2,360,150.0);
		Produto prod3 = new Produto(null, "E-CPF", "CPF",pc2,360, 80.0);
		prodrepo.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		
			
		EstadoPedido ep1 = EstadoPedido.EM_ABERTO;
		EstadoPagamento ep2 = EstadoPagamento.LOCAL;
		
		Pedido p1 = new Pedido(null, 55, cpf1,null,prod1,ep1,ep2,sdf2.parse("26/02/2019 13:37"));
		Pedido p2 = new Pedido(null, 55, cpf2,null,prod1,ep1,ep2,sdf2.parse("26/02/2019 13:37"));
		Pedido p3 = new Pedido(null, 55, cpf3,null,prod2,ep1,ep2,sdf2.parse("26/02/2019 13:37"));
		Pedido p4 = new Pedido(null, 55, null,cpj1,prod2,ep1,ep2,sdf2.parse("26/02/2019 13:37"));
		Pedido p5 = new Pedido(null, 55, null,cpj2,prod3,ep1,ep2,sdf2.parse("26/02/2019 13:37"));
		prepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		
		
		
		
	}
}
