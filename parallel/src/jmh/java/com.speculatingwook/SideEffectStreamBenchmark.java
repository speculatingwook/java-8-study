package com.speculatingwook;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class SideEffectStreamBenchmark {

    @Param({"10000000"})
    private long N;

    @Benchmark
    public long sideEffectSum(Blackhole bh) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, N).forEach(accumulator::add);
        return accumulator.total;
    }

    @Benchmark
    public long sideEffectParallelSum(Blackhole bh) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, N).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }

    public static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }
}
