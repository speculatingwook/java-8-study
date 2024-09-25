package org.speculatingwook;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveExamples {

    public Mono<String> reactiveOperation(String input) {
        return Mono.just(input)
                .map(str -> "Result: " + str)
                .delayElement(java.time.Duration.ofSeconds(1));
    }

    public Flux<String> reactiveStream(int count) {
        return Flux.range(1, count)
                .map(i -> "Item " + i)
                .flatMap(this::reactiveOperation);
    }
}
