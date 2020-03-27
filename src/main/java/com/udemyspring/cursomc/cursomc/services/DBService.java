package com.udemyspring.cursomc.cursomc.services;

import com.udemyspring.cursomc.cursomc.domain.*;
import com.udemyspring.cursomc.cursomc.domain.enums.EstadoPagamento;
import com.udemyspring.cursomc.cursomc.domain.enums.TipoCliente;
import com.udemyspring.cursomc.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {
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

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void instantiateTestDataBase() throws ParseException {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Recursos Humanos");
        Categoria cat4 = new Categoria(null, "Financeiro");
        Categoria cat5 = new Categoria(null, "Atendimento");
        Categoria cat6 = new Categoria(null, "Suporte Técnico");
        Categoria cat7 = new Categoria(null, "Logistica");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Monitor", 500.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 200.00);
        Produto p7 = new Produto(null, "TV true color", 1200.00);
        Produto p8 = new Produto(null, "Roçadeira", 800.00);
        Produto p9 = new Produto(null, "Abajour", 100.00);
        Produto p10 = new Produto(null, "Pendente", 180.00);
        Produto p11 = new Produto(null, "Shampoo", 90.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "09563568999", TipoCliente.PESSOAFISICA);
        Cliente cli2 = new Cliente(null, "Aldev Corporation", "guzzdev2020@gmail.com", "84656821000155", TipoCliente.PESSOAJURIDICA);

        cli1.getTelefones().addAll(Arrays.asList("31999988852", "1199898976"));
        cli2.getTelefones().addAll(Arrays.asList("41995368424", "4136011234"));

        Endereco e1 = new Endereco(null, "Avenida Flores", "300", "Apto 203", "Jardim", "38777034", cli1, c1);
        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
        Endereco e3 = new Endereco(null, "Avenida Afonso", "99", "Casa", "Jardim Claudia", "83326555", cli2, c3);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
        Pedido ped3 = new Pedido(null, sdf.parse("01/01/2020 10:10"), cli2, e3);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        Pagamento pagto3 = new PagamentoComCartao(null, EstadoPagamento.CANCELADO, ped3, 10);
        ped3.setPagamento(pagto3);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
        cli2.getPedidos().addAll(Arrays.asList(ped3));

        pedidoRepository.saveAll(Arrays.asList(ped1,ped2, ped3));
        pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2, pagto3));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 500.00);
        ItemPedido ip4 = new ItemPedido(ped3, p1, 25.00, 2, 2000.00);
        ItemPedido ip5 = new ItemPedido(ped3, p2, 10.00, 2, 500.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));
        ped3.getItens().addAll(Arrays.asList(ip4, ip5));

        p1.getItens().addAll(Arrays.asList(ip1, ip4));
        p2.getItens().addAll(Arrays.asList(ip3, ip5));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4, ip5));
    }
}
