package org.example.jmh;

import org.example.App;
import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark) // scope.thread?
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 1)
public class CanCreateNoteBenchmark {
    @Param({ "10", "100", "500", "1000" })
    public int noteLength;

    @Param({ "10", "100", "500", "1000" })
    public int articleLength;

    private String note;
    private String[] articles;

    @Benchmark
    public boolean canCreateNoteBenchmark() {
        note = "a".repeat(noteLength);
        articles = new String[]{ "a".repeat(articleLength)};

        return App.canCreateNote(note, articles);
    }

    // @Timeout(time = 5, timeUnit = TimeUnit.NANOSECONDS)
}