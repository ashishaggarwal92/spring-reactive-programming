package com.home.reactive.learning.flux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearnService {

    // create Flux
    public Flux<String> createFlux() {
        return Flux.just("Ashish", "Binod", "Cheenu").log();
    }

    public Flux<String> createFluxFromList() {
        List<String> fruitList = Arrays.asList("Mango", "Apple");
        return Flux.fromIterable(fruitList).log();
    }
    // create Flux empty
    public Flux<Void> createFluxEmpty() {
        return Flux.empty();
    }

    public Flux<String> createFluxAndLog() {
        return Flux
                .just("flux1 created", "flux2")
                .log();
    }

    // map()
    public Flux<String> map() {
        return createFlux().map(String::toUpperCase);
    }

    // filter()
    public Flux<String> filter() {
        return createFlux().filter(name -> name.length() > 5).log();
    }

    // flatMap()
    public Flux<String> flatMap() {
        return createFlux().flatMap(val -> Flux.just(val.split("")));
    }

    // transform()
    public Flux<String> transform() {
        Function<Flux<String>, Flux<String>> functionInt = name -> name.map(String::toUpperCase);
        return createFlux().transform(functionInt).log();
    }

    // defaultIfEmpty()
    public Flux<String> defaultIfEmpty() {
        return createFlux().filter(name -> name.length() > 8).defaultIfEmpty("No Name").log();
    }

    // switchIfEmpty()
    public Flux<String> switchIfEmpty() {
        return createFlux().filter(name -> name.length() > 8).switchIfEmpty(Flux.just("Apple")).log();
    }

}
