package com.udemyspring.cursomc.cursomc;

import com.udemyspring.cursomc.cursomc.domain.*;
import com.udemyspring.cursomc.cursomc.domain.enums.TipoCliente;
import com.udemyspring.cursomc.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Recursos Humanos");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Monitor", 500.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p1));
        cat3.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");
        Estado est3 = new Estado(null, "Paraná");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Curitiba", est3);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2));
        est3.getCidades().addAll(Arrays.asList(c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
        cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", " 09563568999", TipoCliente.PESSOAFISICA);
        Cliente cli2 = new Cliente(null, "Aldev Corporation", "aldevcorp@aldev.com.br", "84656821000155", TipoCliente.PESSOAJURIDICA);

        cli1.getTelefones().addAll(Arrays.asList("31999988852", "11998989976"));
        cli2.getTelefones().addAll(Arrays.asList("41995368424", "4136011234"));

        Endereco e1 = new Endereco(null, "Avenida Flores", "300", "Apto 203", "Jardim", "38777034", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
        Endereco e3 = new Endereco(null, "Avenida Afonso", "99", "Casa", "Jardim Claudia", "83326555", cli2, c3);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
    }
}

