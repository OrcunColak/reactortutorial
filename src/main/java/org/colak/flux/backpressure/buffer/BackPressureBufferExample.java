package org.colak.flux.backpressure.buffer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
class BackPressureBufferExample {

    public static void main() throws Exception {
        Flux<Integer> flux = Flux.range(1, 100)
                .delayElements(Duration.ofMillis(1))
                .doOnNext(i -> log.info("Produced: " + i))
                .onBackpressureBuffer(10, dropped -> log.info("Buffered, dropped: " + dropped));

        flux.subscribeOn(Schedulers.boundedElastic())
                .subscribe(
                        data -> {
                            try {
                                // Simulating a task that takes 10ms
                                Thread.sleep(100);
                                log.info("Consumed: " + data);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                throw new RuntimeException(e);
                            }
                        },
                        err -> log.error("Error: " + err),
                        () -> log.info("Completed")
                );

        // Keep the program running long enough to see the output
        System.out.println("Print a key to exit");
        System.in.read();
        System.exit(0);

    }
}
