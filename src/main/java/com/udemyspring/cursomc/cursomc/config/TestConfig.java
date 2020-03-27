package com.udemyspring.cursomc.cursomc.config;

import com.udemyspring.cursomc.cursomc.services.DBService;
import com.udemyspring.cursomc.cursomc.services.EmailService;
import com.udemyspring.cursomc.cursomc.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDataBase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }


}
