package org.colak.flux.pubsub;

class PubSubTest {

    public static void main() {
        EventPublisher publisher = new EventPublisher();
        EventSubscriber eventSubscriber1 = new EventSubscriber("subscriber-1", publisher.getEvents());


        EventSubscriber eventSubscriber2 = new EventSubscriber("subscriber-2", publisher.getEvents());
        publisher.publishEvent("2");

    }
}
