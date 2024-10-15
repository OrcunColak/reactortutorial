package org.colak.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Emit all items initially and then emit the new item
 */
@Slf4j
class FluxTest {

    private static final List<ToDo> toDoList = new ArrayList<>(List.of(
            new ToDo("1", "title1"),
            new ToDo("2", "title2")
    ));

    public static void main() throws InterruptedException {
        // replay a specified history size of pushed data to new subscribers then continue pushing new data live.
        Sinks.Many<ToDo> todoSink = Sinks.many().replay().all();
        Flux<ToDo> flux = todoSink.asFlux();

        // Subscribe to the Flux and print the received elements
        flux.subscribe(System.out::println);

        toDoList.forEach(todoSink::tryEmitNext);

        // Simulate adding a new item
        ToDo newTodo = new ToDo("3", "title3");
        toDoList.add(newTodo);
        todoSink.tryEmitNext(newTodo);

        TimeUnit.SECONDS.sleep(2);
    }

}
