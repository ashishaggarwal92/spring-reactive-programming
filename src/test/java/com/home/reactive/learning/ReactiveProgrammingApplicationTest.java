package com.home.reactive.learning;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@SpringBootTest
public class ReactiveProgrammingApplicationTest {

    @Test
    public void test() {

        System.out.println("Test Started");

        // Mono and Flux are publisher
        // Mono -- 0 or 1 item
        // Flux -- 0 or n

        Mono<String> monoPublisher = Mono.just("testing data provided by publisher");

        // First way
        monoPublisher.subscribe(new CoreSubscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Subscription done");
                subscription.request(1);
            }

            @Override
            public void onNext(String s) {
                System.out.println("data : "+ s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error : " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });

        // Second way
        monoPublisher.subscribe(System.out::println);


    }

}
