package org.colak.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * See <a href="https://github.com/cagatay35/reactive-streams/blob/main/src/main/java/org/cagatay/spring/examples/reactivestreams/ToDoManager.java">...</a>
 */
@Slf4j
public class SinksTest {

    private static final List<ToDo> toDoList = new ArrayList<>(List.of(
            new ToDo("1", "title1"),
            new ToDo("2", "title2")
    ));

    private static final Sinks.Many<ToDo> todoSink = Sinks.many().replay().all();

    public static void main(String[] args) throws InterruptedException {
        Flux<ToDo> flux = todoSink.asFlux();

        flux
                //  allowing multiple subscribers to share the emissions
                .share()
                // Subscribe to the flux and add emitted todos to the list
                .subscribe(toDoList::add);

        ToDo newTodo = new ToDo("3", "title3");
        todoSink.tryEmitNext(newTodo);

        // Print the updated list
        log.info("Updated ToDo List: " + toDoList);

        TimeUnit.SECONDS.sleep(2);
    }

}
