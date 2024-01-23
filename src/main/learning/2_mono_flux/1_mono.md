# MONO

- publisher that have 0...1 items
- This is the implementation of publisher

[Code](./../../java/com/home/reactive/learning/mono/MonoLearning.java)
[Test](./../../../test/java/com/home/reactive/learning/mono/TestMonoLearning.java)

## Creating MONO

    Mono<String> mono=Mono.just("data")

## log()
- to log mono operation
- It will have flow of events

      14:37:34.901 [main] DEBUG reactor.util.Loggers - Using Slf4j logging framework
      14:37:34.910 [main] INFO reactor.Mono.Just.1 - | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
      14:37:34.912 [main] INFO reactor.Mono.Just.1 - | request(unbounded)
      14:37:34.912 [main] INFO reactor.Mono.Just.1 - | onNext(mono created)
      mono created
      14:37:34.913 [main] INFO reactor.Mono.Just.1 - | onComplete()

## Error

    Mono.just("data").then(Mono.error(new RuntimeException("ERROR")))

## zip() 
- merge mono provide Mono of Tuple

## zipWith()
- combines the result from this mono and another mono



        var m1=Mono.just("First");
        var m2=Mono.just("Second");
        Mono<Tuple2<String, String>> tuple2Mono = m1.zipWith(m2);
        tuple2Mono.subscribe(values->{
            System.out.println(values.getT1());
            System.out.println(values.getT2());
        });

## map()
 - transform the value emmited by current using syn function


      var m1 = Mono.just("First Project working");
      var m2 = Mono.just(124);

      Mono<String> changeMono = m1.map(item -> item.toUpperCase());
      changeMono.subscribe(System.out::println);

## flatMap() 

- transform the value emmited by current mono async, returning the value emmited by another mono (change value type possible )

## flatMapMany() 

- transform this mono into publisher , then change to return a many value that is Flux.

        var m1 = Mono.just("First");
        var m2 = Mono.just(124);

        Flux<Object> integerMono = m1.flatMapMany(item1 -> Mono.jsut(item1.split(" ")));
        integerMono.subscribe(System.out::println);

## concatWith()
- join two mono and provide Flux

        var m1 = Mono.just("First Project working");
        var m2 = Mono.just(124);
        Flux<String> secondString = m1.concatWith(Mono.just("second string"));

## delayElement() 
- to provide delay on onNext()
- main thread wont wait for the delay and start working on other task

