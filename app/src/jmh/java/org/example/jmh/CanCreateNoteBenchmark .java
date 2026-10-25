package org.example.jmh;

import org.example.App;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)
public class CanCreateNoteBenchmark {
  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.NANOSECONDS)
  public void canCreateNoteBenchmark(Blackhole bh) {
      
    bh.consume(output);
  }
}
