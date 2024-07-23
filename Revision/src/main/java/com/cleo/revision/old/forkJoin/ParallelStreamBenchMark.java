package com.cleo.revision.old.forkJoin;


import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
/**
 * To run using maven, compile the project
 * Then a benchmarks.jar will be created
 * Run that to see the performance
 */

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = { "-Xms4G", "-Xmx4G" })
@Measurement(iterations = 2)
@Warmup(iterations = 3)
public class ParallelStreamBenchMark {

    private static final long N= 10_000_000L;

    @Benchmark
    public static long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1).limit(N)
                .reduce( 0L, Long::sum);
    }
    @Benchmark
    public static long rangedSum() {
        return LongStream.rangeClosed(1, N)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        rangedSum();
    }

}
