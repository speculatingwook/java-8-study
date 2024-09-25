package org.speculatingwook;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class AsyncService {
    private final CompletableFutureExamples cfExamples;
    private final ReactiveExamples reactiveExamples;

    public AsyncService() {
        this.cfExamples = new CompletableFutureExamples();
        this.reactiveExamples = new ReactiveExamples();
    }

    public CompletableFuture<String> performAsyncTask(String input) {
        return cfExamples.chainedAsyncOperations(input);
    }

    public Mono<String> performReactiveTask(String input) {
        return reactiveExamples.reactiveOperation(input);
    }

    public Flux<String> generateReactiveStream(int count) {
        return reactiveExamples.reactiveStream(count);
    }

    public void shutdown() {
        cfExamples.shutdown();
    }
}
