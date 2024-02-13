package org.colak.flux.pubsub;

import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@Getter
public class EventPublisher {

    private FluxSink<String> fluxSink;
    private final Flux<String> events;

    public EventPublisher() {
        events = Flux.create((FluxSink<String> fluxSink) -> this.fluxSink = fluxSink)
                // broadcast
                .share();
    }

    public Mono<String> publishEvent(String str) {
        return Mono.fromRunnable(() -> this.fluxSink.next(str))
                // Return an empty Mono to represent completion
                .thenReturn(str);
    }

}
