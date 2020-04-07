package com.udemyspring.cursomc.cursomc;

import com.udemyspring.cursomc.cursomc.domain.*;
import com.udemyspring.cursomc.cursomc.domain.enums.EstadoPagamento;
import com.udemyspring.cursomc.cursomc.domain.enums.TipoCliente;
import com.udemyspring.cursomc.cursomc.repositories.*;
import com.udemyspring.cursomc.cursomc.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private S3Service s3Service;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        s3Service.uploadFile("C:\\Users\\AU40044421\\Pictures\\carro.jpg");
    }
}

