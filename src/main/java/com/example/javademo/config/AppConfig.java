package com.example.javademo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.javademo.repositories") // Reemplaza por tu paquete base
public class AppConfig {
    // Configuración adicional si es necesario
}

