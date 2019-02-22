package com.signer.vendas;




import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.signer.vendas.domain.Cliente;

import com.signer.vendas.domain.ClientePJ;
import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.repository.ClientePJRepository;
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
    
    
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		ProdutoCategoria pc1 = new ProdutoCategoria(null,"CD");
		ProdutoCategoria pc2 = new ProdutoCategoria(null,"PEN DRIVE");
		ProdutoCategoria pc3 = new ProdutoCategoria(null,"MIDIA DIGITAL");
		
		pcrepo.saveAll(Arrays.asList(pc1,pc2,pc3));
		
		Cliente c1 = new Cliente(null, "brunotardio@gmail.com", "123");
		Cliente c2 = new Cliente(null, "tardio@gmail.com", "123");
		Cliente c3 = new Cliente(null, "fernando@gmail.com", "123");
		Cliente c4 = new Cliente(null, "gustavo@gmail.com", "123");
		Cliente c5 = new Cliente(null, "bruno@gmail.com", "123");
		
		crepo.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		System.out.print(c1);
		ClientePJ cpj1 = new ClientePJ(null, "TardioTEC", "Tardio aplicacoes", "44777799595", "9600600", "mei", c1);
		ClientePJ cpj2 = new ClientePJ(null, "TardioTEC 02 ", "Tardio websites", "65656005", "9322200", "simples", c1);
		ClientePJ cpj3 = new ClientePJ(null, "Limtda", "Gustavo mecanico", "000651050", "4444444", "eirele", c4);
		
		cpjrepo.saveAll(Arrays.asList(cpj1,cpj2,cpj3));
		
		
	}





	
	

}
