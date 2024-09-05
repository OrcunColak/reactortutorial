package org.colak.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Emit a new item, this item will be added to list by flux
 */
@Slf4j
public class SinksTest {

    private static final List<ToDo> toDoList = new ArrayList<>(List.of(
            new ToDo("1", "title1"),
            new ToDo("2", "title2")
    ));


    public static void main(String[] args) throws InterruptedException {
        // replay a specified history size of pushed data to new subscribers then continue pushing new data live.
        Sinks.Many<ToDo> todoSink = Sinks.many().replay().all();
        Flux<ToDo> flux = todoSink.asFlux();

        flux
                //  allowing multiple subscribers to share the emissions
                .share()
                // Subscribe to the flux and add emitted todos to the list
                .subscribe(toDoList::add);

        ToDo newTodo = new ToDo("3", "title3");
        todoSink.tryEmitNext(newTodo);

        // Print the updated list
        log.info("Updated ToDo List: {}", toDoList);

        TimeUnit.SECONDS.sleep(2);
    }

}
