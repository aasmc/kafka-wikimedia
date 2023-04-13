package ru.aasmc.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import ru.aasmc.wikimedia.service.WikimediaProducer;

@ConfigurationPropertiesScan
@SpringBootApplication
public class WikimediaProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WikimediaProducerApplication.class);
    }

    @Autowired
    private WikimediaProducer producer;
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            producer.sendMessage();
        };
    }
}
