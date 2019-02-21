package com.signer.vendas;



import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.signer.vendas.domain.ProdutoCategoria;
import com.signer.vendas.repository.ProdutoCategoriaRepository;



@SpringBootApplication
public class Application implements CommandLineRunner {

	
	@Autowired
	ProdutoCategoriaRepository pcrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		ProdutoCategoria pc1 = new ProdutoCategoria(null,"CD");
		ProdutoCategoria pc2 = new ProdutoCategoria(null,"PEN DRIVE");
		ProdutoCategoria pc3 = new ProdutoCategoria(null,"MIDIA DIGITAL");
		
		pcrepo.saveAll(Arrays.asList(pc1,pc2,pc3));
	}





	
	

}
