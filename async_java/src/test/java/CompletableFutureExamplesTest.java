import org.junit.jupiter.api.Test;
import org.speculatingwook.CompletableFutureExamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureExamplesTest {
    @Test
    void testAsyncOperation() throws ExecutionException, InterruptedException {
        CompletableFutureExamples examples = new CompletableFutureExamples();
        CompletableFuture<String> future = examples.asyncOperation("test");
        assertEquals("Result: test", future.get());
        examples.shutdown();
    }

    @Test
    void testChainedAsyncOperations() throws ExecutionException, InterruptedException {
        CompletableFutureExamples examples = new CompletableFutureExamples();
        CompletableFuture<String> future = examples.chainedAsyncOperations("test");
        assertEquals("Result: Result: test - processed", future.get());
        examples.shutdown();
    }
}
