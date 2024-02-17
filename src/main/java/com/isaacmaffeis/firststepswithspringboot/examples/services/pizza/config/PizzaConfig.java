package com.isaacmaffeis.firststepswithspringboot.examples.services.pizza.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="pizza")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PizzaConfig {
    private String sauce = "no"; // default
    private String topping;
    private String crust;
}
