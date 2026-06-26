package com.hexagonal_core_banking.banking_api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("h2")
@ComponentScan(basePackages = "com.hexagonal_core_banking.banking_h2_adapter")
@EnableJpaRepositories(
    basePackages = "com.hexagonal_core_banking.banking_h2_adapter.infrastructure.repository"
)
@EntityScan(
    basePackages = "com.hexagonal_core_banking.banking_h2_adapter.infrastructure.entity"
)
public class H2AdapterConfig {

}