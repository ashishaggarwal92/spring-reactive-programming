package com.home.reactive.learning.flux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class TestFluxLearning {

    @Autowired
    FluxLearnService fluxLearnService;

    @Test
    public void test() {
        System.out.println("Test Started");
    }

    @Test
    public void test_createFlux() {
        fluxLearnService.createFlux().subscribe(data -> {
            System.out.println("Creating Flux");
            System.out.println(data);

        });
    }

    @Test
    public void test_createFluxFromList() {
        fluxLearnService.createFluxFromList().subscribe(System.out::println);
    }

    @Test
    public void test_createFluxAndLog() {
        fluxLearnService.createFluxAndLog().subscribe(System.out::println);
    }

    @Test
    public void test_map() {
        Flux<String> capFlux = fluxLearnService.map();
        StepVerifier.create(capFlux)
                .expectNextCount(3)
                .verifyComplete();

        StepVerifier.create(capFlux)
                .expectNext("Ashish".toUpperCase(), "Binod".toUpperCase(), "Cheenu".toUpperCase())
                .verifyComplete();
    }

    @Test
    public void test_filter() {
        Flux<String> capFlux = fluxLearnService.filter();
        StepVerifier.create(capFlux)
                .expectNextCount(2)
                .verifyComplete();

        StepVerifier.create(capFlux)
                .expectNext("Ashish",  "Cheenu")
                .verifyComplete();
    }

    @Test
    public void test_flatMap() {
        Flux<String> capFlux = fluxLearnService.flatMap();
        StepVerifier.create(capFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    public void test_transform() {
        Flux<String> capFlux = fluxLearnService.transform();
        StepVerifier.create(capFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    public void test_defaultIfEmpty() {
        Flux<String> capFlux = fluxLearnService.defaultIfEmpty();
        StepVerifier.create(capFlux)
                .expectNextCount(1)
                .verifyComplete();
    }


}
