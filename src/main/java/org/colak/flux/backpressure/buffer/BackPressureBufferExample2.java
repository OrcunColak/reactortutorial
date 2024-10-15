package org.colak.flux.backpressure.buffer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
class BackPressureBufferExample2 {

    public static void main() throws Exception {
        Flux.range(1, 1_000_000)
                .onBackpressureBuffer(1024)
                .subscribe(System.out::println);

    }
}
