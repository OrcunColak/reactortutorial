package org.colak.flux.pubsub;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class EventSubscriber {

    private final String name;

    public EventSubscriber(String name, Flux<String> flux) {
        this.name = name;
        flux.subscribe(
                this::handleEvent,
                throwable -> log.error("Error: " + throwable),
                () -> log.info("Completed")
        );
    }

    private void handleEvent(String event) {
        // Logic to handle the event (e.g., logging, additional processing)
        log.info("{} Received event: {}", name, event);
    }
}
