import org.junit.jupiter.api.Test;
import org.speculatingwook.ReactiveExamples;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ReactiveExamplesTest {
    @Test
    void testReactiveOperation() {
        ReactiveExamples examples = new ReactiveExamples();
        Mono<String> mono = examples.reactiveOperation("test");
        StepVerifier.create(mono)
                .expectNext("Result: test")
                .verifyComplete();
    }

    @Test
    void testReactiveStream() {
        ReactiveExamples examples = new ReactiveExamples();
        Flux<String> flux = examples.reactiveStream(3);
        StepVerifier.create(flux)
                .expectNext("Result: Item 1")
                .expectNext("Result: Item 2")
                .expectNext("Result: Item 3")
                .verifyComplete();
    }
}
