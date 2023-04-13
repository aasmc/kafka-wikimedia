package ru.aasmc.wikimedia.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.aasmc.wikimedia.entity.WikimediaData;
import ru.aasmc.wikimedia.repository.WikimediaDataRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaDatabaseConsumer {
    private final WikimediaDataRepository repository;

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessage) {
        log.info("Wikimedia event message {}", eventMessage);
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }
}
