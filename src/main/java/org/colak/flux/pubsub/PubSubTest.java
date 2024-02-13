package org.colak.flux.pubsub;

public class PubSubTest {

    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        EventSubscriber eventSubscriber1 = new EventSubscriber("subscriber-1", publisher.getEvents());


        EventSubscriber eventSubscriber2 = new EventSubscriber("subscriber-2", publisher.getEvents());
        publisher.publishEvent("1");
        publisher.publishEvent("2");

    }
}
