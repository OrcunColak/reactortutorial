package org.colak.mono.ontimeout;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
class TimeoutTest {
    public static void main() throws InterruptedException {
        // Simulating a Mono that takes longer than the timeout
        Mono<String> delayedMono = Mono.delay(Duration.ofSeconds(5))
                .map(duration -> "Delayed Result");

        // Using timeout to enforce a time limit
        Mono<String> resultMono = delayedMono
                .timeout(Duration.ofSeconds(3), Mono.just("Timeout result"));

        // Subscribing to the resultMono
        resultMono.subscribe(
                value -> log.info("Result: " + value)
        );

        TimeUnit.SECONDS.sleep(10);
    }
}
