package ru.aasmc.wikimedia.service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.aasmc.wikimedia.handler.WikimediaHandlerTopic;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void sendMessage() {
        String topic = "wikimedia_recentchange";

        // to read realtime stream data from WikiMedia we use event source
        EventHandler handler = new WikimediaHandlerTopic(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(handler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }

}
