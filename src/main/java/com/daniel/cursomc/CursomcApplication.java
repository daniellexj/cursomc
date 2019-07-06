package com.daniel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Produto;
import com.daniel.cursomc.repositories.CategoriaRepository;
import com.daniel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Categoria cat1 = new Categoria(null,"Informatica");
		 Categoria cat2 = new Categoria(null,"Escritorio");
		 
		 Produto p1 = new Produto(null,"Computadores",2000.00);
		 Produto p2 = new Produto(null,"Impresora",800.00);
		 Produto p3 = new Produto(null,"Mouse",80.00);
		 
		 cat1.getProduto().addAll(Arrays.asList(p1,p2,p3));
		 cat2.getProduto().addAll(Arrays.asList(p2));
		 
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat2));
		 
		 categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		 produtoRepository.saveAll(Arrays.asList(p1, p2,p3));
		
	}

}
