package com.speculatingwook;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
@Fork(1)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
public class MyBenchmark {
    private long N = 100000000L;

    @Benchmark
    public long sumReducing() {
        int result = 0;

        for(long i=1L; i<=N; i++) {
            result += i;
        }

        return result;
    }
}