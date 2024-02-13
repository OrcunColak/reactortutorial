package org.colak.flux.pubsub;

import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Getter
public class EventPublisher {

    private FluxSink<String> fluxSink;
    private final Flux<String> events;

    public EventPublisher() {
        events = Flux.create((FluxSink<String> fluxSink) -> this.fluxSink = fluxSink)
                // broadcast
                .share();
    }

    public void publishEvent(String str) {
        this.fluxSink.next(str);
    }

}
