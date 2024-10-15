package org.colak.flux.fromiterable;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Slf4j
class FromIterableTest {

    public static void main() {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Create a Flux from the list
        Flux<Integer> numberFlux = Flux.fromIterable(numbers)
                .map(number -> number * number)  // find the square of each number
                .filter(number -> number > 5); // Filter: Only allow numbers greater than 5

        numberFlux.subscribe(
                result -> log.info("Result: {}", result),
                error -> log.error("Error: {}", error.getMessage())
        );
    }
}
