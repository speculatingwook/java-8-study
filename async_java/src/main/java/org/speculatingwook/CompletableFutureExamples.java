package org.speculatingwook;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExamples {

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public CompletableFuture<String> asyncOperation(String input) {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate some work
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Result: " + input;
        }, executor);
    }

    public CompletableFuture<String> chainedAsyncOperations(String input) {
        return asyncOperation(input)
                .thenApply(result -> result + " - processed")
                .thenCompose(this::asyncOperation);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
