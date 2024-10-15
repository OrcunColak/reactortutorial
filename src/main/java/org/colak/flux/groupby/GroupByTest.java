package org.colak.flux.groupby;

import lombok.extern.slf4j.Slf4j;

// Grouping operators enable you to group elements in a Flux based on specific criteria.
@Slf4j
class GroupByTest {

    public static void main() {
        reactor.core.publisher.Flux.range(1, 10)
                .groupBy(num -> num % 2 == 0)
                .subscribe(groupedFlux -> {
                    if (groupedFlux.key()) {
                        // Handle even numbers
                        groupedFlux.subscribe(evenNumber -> log.info("Even: " + evenNumber));
                    } else {
                        // Handle odd numbers
                        groupedFlux.subscribe(oddNumber -> log.info("Odd: " + oddNumber));
                    }
                });
    }
}
