package org.colak.flux.genericrepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenericService {

    private final Map<Integer, String> studentDatabase = new ConcurrentHashMap<>();

    public Mono<String> getById(Integer studentId) {
        return Mono.justOrEmpty(studentDatabase.get(studentId));
    }

    public Mono<String> createStudent(Integer studentId, String name) {
        studentDatabase.put(studentId, name);
        return Mono.just(name);
    }

    public Flux<String> getAllStudents() {
        return Flux.fromIterable(studentDatabase.values());
    }
}
