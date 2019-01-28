package com.projeto.teste.neogridfile.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class FtpConfiguration {

    @Value("${ftp.entrada}")
    private String ftpEntrada;

    public String getFtpEntrada() {
        return ftpEntrada;
    }

    public void setFtpEntrada(String ftpEntrada) {
        this.ftpEntrada = ftpEntrada;
    }
}
