package stepverifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * See <a href="https://medium.com/@kshitij.13srivastav/mastering-back-pressure-and-reactive-programming-with-spring-webclient-ed152f3cd8de">...</a>
 */
@Slf4j
class StepVerifierTest {

    @Test
    void testExpectNext() {
        int count = 100;
        Flux<Integer> flux = Flux.range(1, count)
                .delayElements(Duration.ofMillis(1))
                .doOnNext(data -> {
                    log.info("Received data: {}", data);
                })
                .onBackpressureLatest();

        StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(1)  // Request only one item initially
                .expectNext(1)
                .thenRequest(2)  // Request two more items
                .expectNext(2, 3)
                .thenRequest(3)  // Request three more items
                .expectNext(4, 5, 6)
                .thenCancel()    // Cancel the subscription
                .verify(Duration.ofSeconds(5));  // Verify within a specified time
    }

    @Test
    void testExpectNextCount() {
        int count = 100;
        Flux<Integer> flux = Flux.range(1, count)
                .delayElements(Duration.ofMillis(1))
                .doOnNext(data -> {
                    log.info("Received data: {}", data);
                })
                .onBackpressureLatest();

        // Verify that the total emitted elements match the expected count
        StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(Long.MAX_VALUE)
                .expectNextCount(count)  // Assuming the service generates count numbers
                .verifyComplete();

        // Verify that the stream can emit for the second time
        StepVerifier.create(flux)
                .expectSubscription()
                .thenRequest(Long.MAX_VALUE)
                .expectNextCount(count)  // Assuming the service generates count numbers
                .verifyComplete();
    }
}
