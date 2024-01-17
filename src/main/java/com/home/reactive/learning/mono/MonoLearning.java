package com.home.reactive.learning.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;

public class MonoLearning {



    public void createMono() {
        Mono<String> simpleMono = Mono.just("Return String");
        Mono<String> simpleMono1 = Mono.justOrEmpty("Return String");
        simpleMono.subscribe(System.out::println);
        simpleMono1.subscribe(System.out::println);

    }

    public void createMonoAndLog() {
        Mono<String> simpleMono = Mono
                .just("mono created")
                .log();
        simpleMono.subscribe(System.out::println);

    }

    public void monoChainingWithError() {
        Mono<String> errorMono = Mono.error(new RuntimeException("Error !!"));
        Mono<String> simpleMono = Mono
                .just("mono created")
                .log()
                .then(errorMono);
        simpleMono.subscribe(System.out::println);

    }

    public void mono_zip() {
        // ex 1
        Mono<String> simpleMono = Mono.just("Return String 1");
        Mono<String> simpleMono1 = Mono.justOrEmpty("Return String 2");

        Mono<Tuple2<String, String>> combinedMono = Mono.zip(simpleMono, simpleMono1);
        combinedMono.subscribe(data -> {
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });

        // ex 2
        Mono<String> simpleMono3 = Mono.just("Return String 3");
        Mono<String> simpleMono4 = Mono.justOrEmpty("Return String 4");
        Mono<Integer> integerMono = Mono.just(1234);

        Mono<Tuple3<String, String, Integer>> combinedMono1 = Mono.zip(simpleMono, simpleMono1, integerMono);
        combinedMono1.subscribe(data -> {
            System.out.println(data.getT1());
            System.out.println(data.getT2());
            System.out.println(data.getT3());
        });

    }

    public void zipWith() {
        // ex 1
        Mono<String> simpleMono = Mono.just("Return String 1");
        Mono<String> simpleMono1 = Mono.justOrEmpty("Return String 2");

        Mono<Tuple2<String, String>> combinedMono = simpleMono.zipWith(simpleMono1);
        combinedMono.subscribe(data -> {
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });
    }

    public void map() {
        Mono<String> simpleMono = Mono.just("Return String 1");
        Mono<String> changeMono = simpleMono.map(item -> item.toUpperCase());
        changeMono.subscribe(System.out::println);
    }

    public void flatMap() {
        Mono<String> simpleMono = Mono.just("Return String 1");
        Mono<String[]> changeMono = simpleMono.flatMap(val -> Mono.just(val.split(" ")));
        changeMono.subscribe(System.out::println);
    }

    public void flatMapMany() {
        Mono<String> m1 = Mono.just("First");
        Mono<Integer> m2 = Mono.just(124);

        Flux<Object> integerMono = m1.flatMapMany(item1 -> Flux.just(item1.split(" ")));
        integerMono.subscribe(System.out::println);
    }

    public void concatWith() {
        Mono<String> m1 = Mono.just("First");
        Mono<String> m2 = Mono.just("Second");

        Flux<String> integerMono = m1
                .concatWith(m2)
                .log();
        integerMono.subscribe(System.out::println);
    }


    public void concatWithAndDelay() throws InterruptedException {
        Mono<String> m1 = Mono.just("First");
        Mono<String> m2 = Mono.just("Second");
        System.out.println("Current Thread is : " + Thread.currentThread().getName());
        Flux<String> stringFlux = m1
                .concatWith(m2)
                .log()
                .delayElements(Duration.ofSeconds(2));

        stringFlux.log().subscribe(data -> {
            System.out.println("Current Thread is : " + Thread.currentThread().getName());
            System.out.println("Data is : " + data);
        });
        Thread.sleep(6000);
        System.out.println("terminated main thread");
    }

    public void delay() throws InterruptedException {
        Mono<String> m1 = Mono.just("First");
        System.out.println("Current Thread is : " + Thread.currentThread().getName());
        Mono<String> stringFlux = m1
                .log()
                .delayElement(Duration.ofSeconds(2));

        stringFlux.log().subscribe(data -> {
            System.out.println("Current Thread is : " + Thread.currentThread().getName());
            System.out.println("Data is : " + data);
        });
        Thread.sleep(6000);
        System.out.println("terminated main thread");
    }

}
