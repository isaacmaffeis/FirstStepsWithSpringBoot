package com.isaacmaffeis.firststepswithspringboot.app.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ModelMapper è una libreria Java utilizzata per mappare automaticamente oggetti di un tipo in oggetti di un altro tipo.
 * È molto utile quando si lavora con oggetti DTO (Data Transfer Object) in applicazioni web.
 */
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Nested Object config
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        /*
        La strategia di corrispondenza LOOSE in ModelMapper è una delle tre strategie di corrispondenza disponibili,
        insieme a STRICT e STANDARD. Queste strategie determinano come ModelMapper mappa i campi tra l’oggetto sorgente
        e l’oggetto destinazione.
        Quando si utilizza questa strategia, ModelMapper ignora le differenze di maiuscole/minuscole e gli underscore
        nei nomi dei campi. Inoltre, ModelMapper considera i campi come corrispondenti anche se i nomi dei campi
        nell’oggetto sorgente e nell’oggetto destinazione non sono esattamente gli stessi, ma contengono le stesse
        parole. Ad esempio, un campo chiamato firstName nell’oggetto sorgente corrisponderebbe a un campo chiamato
        first_name o nameFirst nell’oggetto destinazione.
         */
        return modelMapper;
    }
}
