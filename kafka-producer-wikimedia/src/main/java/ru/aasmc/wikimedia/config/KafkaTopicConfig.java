package ru.aasmc.wikimedia.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import ru.aasmc.wikimedia.config.props.AppKafkaProperties;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    private final AppKafkaProperties properties;

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("wikimedia_recentchange")
                .partitions(properties.getPartitions())
                .replicas(properties.getReplicas())
                .build();
    }

}
