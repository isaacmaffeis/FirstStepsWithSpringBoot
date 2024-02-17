package com.isaacmaffeis.firststepswithspringboot.examples.services.pizza;

import com.isaacmaffeis.firststepswithspringboot.examples.services.pizza.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Log
public class PizzaRunner implements CommandLineRunner {

    PizzaConfig pizzaConfig;

    public PizzaRunner(PizzaConfig pizzaConfig) {
        this.pizzaConfig = pizzaConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(
                String.format("I want a %s crust pizza, with %s and %s sauce",
                        pizzaConfig.getCrust(),
                        pizzaConfig.getTopping(),
                        pizzaConfig.getSauce()
                ));
    }
}
