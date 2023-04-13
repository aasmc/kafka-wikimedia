package ru.aasmc.wikimedia.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafkaprops")
@Data
public class AppKafkaProperties {
    private int partitions;
    private int replicas;
}

