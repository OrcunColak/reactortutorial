package org.colak.flux.delayelements;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;

/**
 * See <a href="https://medium.com/@iamgnanadeep/spring-boot-reactive-programming-explore-the-realm-of-reactive-programming-to-build-lightning-fast-ffacd56853a6">...</a>
 */
public class DelayElementsTest {

    public static void main(String[] args) throws IOException {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1))
                .map(n -> n * 2);

        numbers.subscribe(System.out::println);

        System.out.println("Press a key to exit");
        System.in.read();
        System.exit(0);

    }
}
