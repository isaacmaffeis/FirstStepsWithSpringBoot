package com.isaacmaffeis.firststepswithspringboot.examples.services.colours;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Log
public class ColoursRunner implements CommandLineRunner {

    ColourPrinter colourPrinter;

    public ColoursRunner(ColourPrinter colourPrinter) {
        this.colourPrinter = colourPrinter;
    }

   @Override
    public void run(String... args) throws Exception {
        log.info(colourPrinter.print());
    }

    /*
    In Spring Boot, la classe ColoursRunner viene annotata con @Component, che è una delle annotazioni di base per la
    gestione dei componenti all'interno del contesto dell'applicazione Spring. Quando Spring Boot avvia l'applicazione,
    esegue la scansione del classpath per individuare tutte le classi annotate con @Component, @Service, @Repository,
    @Controller e altre annotazioni simili che indicano che la classe è un componente gestito da Spring.

     Poiché ColoursRunner è annotata con @Component e implementa l'interfaccia CommandLineRunner, Spring Boot
     automaticamente rileva questa classe durante la scansione del classpath e la considera come parte dell'applicazione.
     Quando l'applicazione viene avviata, Spring Boot esegue automaticamente il metodo run all'interno di ColoursRunner,
     poiché questo è il comportamento predefinito per le classi che implementano CommandLineRunner.

     Quindi, anche se non viene esplicitamente chiamato il metodo run nella classe ColoursRunner,
     Spring Boot lo eseguirà comunque quando avvia l'applicazione. Questo è un aspetto del framework Spring Boot che
     sfrutta il concetto di inversione di controllo (IoC) e di gestione dei componenti per semplificare lo sviluppo
     delle applicazioni.
     */
}
