package flux.pubsub;

import org.colak.flux.pubsub.EventPublisher;
import org.colak.flux.pubsub.EventSubscriber;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class PubSubTest {

    @Test
    void testPubSub () {
        EventPublisher publisher = new EventPublisher();
        EventSubscriber eventSubscriber1 = new EventSubscriber("subscriber-1", publisher.getEvents());

        StepVerifier.create(publisher.publishEvent("1"))
                .expectNextCount(0)
                .expectNext("1")
                .verifyComplete();
    }

}
